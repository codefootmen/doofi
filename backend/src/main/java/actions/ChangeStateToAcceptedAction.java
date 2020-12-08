package actions;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Order;

import java.lang.reflect.Method;

public class ChangeStateToAcceptedAction implements ICommand {
    private Order order = Order.builder().build();
    private Gson gson = new Gson();

    @SneakyThrows
    @Override
    public Object execute(String req, int id) {
        Order actualOrder = gson.fromJson(req, order.getClass());

        String actualState = actualOrder.getCurrentStatus();

        Method setNewState = Class.forName("OrderIs"+actualState+"State").getDeclaredMethod("order"+actualState, Order.class);

        return setNewState.invoke(actualOrder);
    }
}

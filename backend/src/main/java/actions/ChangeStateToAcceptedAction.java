package actions;

import actions.ICommand;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Order;
import states.IOrderState;
import utils.NotificationEmitter;

import java.lang.reflect.Method;

public class ChangeStateToAcceptedAction implements ICommand {
    private Order order = Order.builder().build();
    private Gson gson = new Gson();

    @SneakyThrows
    @Override
    public Object execute(String req, int id) {
        Order actualOrder = gson.fromJson(req, Order.class);

        String actualState = actualOrder.getCurrentStatus();

        Class clazz = Class.forName("states.OrderIs"+actualState+"State");
        Method setNewState = clazz.getMethod("orderAccepted", Order.class);
        Object obj = clazz.getDeclaredConstructor().newInstance();

        NotificationEmitter.emit();
        return setNewState.invoke(obj, actualOrder);
    }
}

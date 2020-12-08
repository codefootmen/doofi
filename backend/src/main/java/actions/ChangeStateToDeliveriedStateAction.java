package actions;

import actions.ICommand;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Order;

import java.lang.reflect.Method;

public class ChangeStateToDeliveriedStateAction implements ICommand {
    private Gson gson = new Gson();

    @SneakyThrows
    @Override
    public Object execute(String req, int id) {
        Order actualOrder = gson.fromJson(req, Order.class);

        String actualState = actualOrder.getCurrentStatus();

        Class clazz = Class.forName("states.OrderIs"+actualState+"State");
        Method setNewState = clazz.getMethod("orderDeliveried", Order.class);
        Object obj = clazz.getDeclaredConstructor().newInstance();

        return setNewState.invoke(obj, actualOrder);
    }
}

package states;

import model.Order;

public class OrderIsCreatedState implements IOrderState{

    private static OrderIsCreatedState instance = new OrderIsCreatedState();
    private OrderIsCreatedState(){}

    public static OrderIsCreatedState instance()
    {
        return instance;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Order is created");
        order.setStatus(0);
    }
}

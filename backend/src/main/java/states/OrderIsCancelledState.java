package states;

import model.Order;

public class OrderIsCancelledState implements IOrderState{

    private static OrderIsCancelledState instance = new OrderIsCancelledState();
    private OrderIsCancelledState(){}

    public static OrderIsCancelledState instance()
    {
        return instance;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Order is cancelled");
        order.setStatus(4);
    }
}

package states;

import model.Order;

public class OrderAcceptedState implements IOrderState{

    private static OrderAcceptedState instance = new OrderAcceptedState();
    private OrderAcceptedState(){}

    public static OrderAcceptedState instance()
    {
        return instance;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Order Accepted");
        order.setStatus(1);
    }
}

package states;

import model.Order;

public class OrderIsReadyForDeliveryState implements IOrderState{

    private static OrderIsReadyForDeliveryState instance = new OrderIsReadyForDeliveryState();
    private OrderIsReadyForDeliveryState(){}

    public static OrderIsReadyForDeliveryState instance()
    {
        return instance;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Order is ready for delivery");
        order.setStatus(2);
    }
}

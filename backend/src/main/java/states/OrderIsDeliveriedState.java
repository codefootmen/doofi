package states;

import model.Order;

public class OrderIsDeliveriedState implements IOrderState{

    private static OrderIsDeliveriedState instance = new OrderIsDeliveriedState();
    private OrderIsDeliveriedState(){}

    public static OrderIsDeliveriedState instance()
    {
        return instance;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Order is deliveried");
        order.setStatus(3);
    }
}

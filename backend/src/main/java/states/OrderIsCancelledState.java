package states;

import model.Order;

public class OrderIsCancelledState implements IOrderState{

    @Override
    public boolean orderCreated(Order order) {
        return false;
    }

    @Override
    public boolean orderAccepted(Order order) {
        return false;
    }

    @Override
    public boolean orderSent(Order order) {
        return false;
    }

    @Override
    public boolean orderDeliveried(Order order) {
        return false;
    }

    @Override
    public boolean orderCancelled(Order order) {
        return false;
    }

    @Override
    public String getState() {
        return "order cancelled";
    }
}

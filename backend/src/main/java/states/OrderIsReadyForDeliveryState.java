package states;

import model.Order;

public class OrderIsReadyForDeliveryState implements IOrderState{

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
        try{
            order.setCurrentStatus(new OrderIsDeliveriedState());
            order.updateState();
        }catch (Exception e){
            e.toString();
        }
        return true;
    }

    @Override
    public boolean orderCancelled(Order order) {
        try{
            order.setCurrentStatus(new OrderIsCancelledState());
            order.updateState();
        }catch (Exception e){
            e.toString();
        }
        return true;
    }

    @Override
    public String getState() {
        return "ready for delivery";
    }
}

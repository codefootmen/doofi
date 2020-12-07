package states;

import model.Order;

public class OrderIsCreatedState implements IOrderState{

    @Override
    public boolean orderCreated(Order order) {
        return false;
    }

    @Override
    public boolean orderAccepted(Order order) {
        try{
            order.setCurrentStatus(new OrderAcceptedState());
            order.updateState();
        }catch (Exception e){
            e.toString();
        }
        return true;
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
        return "order created";
    }
}

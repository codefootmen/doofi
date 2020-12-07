package states;

import model.Order;

public class OrderAcceptedState implements IOrderState{

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
        try{
            order.setCurrentStatus(new OrderIsReadyForDeliveryState());
            order.updateState();
        }catch (Exception e){
            e.toString();
        }
        return true;
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
        return "order accepted";
    }


}

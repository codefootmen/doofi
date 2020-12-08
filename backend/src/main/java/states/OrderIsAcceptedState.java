package states;

import model.Order;
import persistence.Dao;

public class OrderIsAcceptedState implements IOrderState{

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
            order.setCurrentStatus("Sent");
            Dao.getInstance().update(order);
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
            order.setCurrentStatus("Cancelled");
            Dao.getInstance().update(order);
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

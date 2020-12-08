package states;

import model.Order;
import persistence.Dao;

import java.sql.Timestamp;

public class OrderIsSentState implements IOrderState{

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
            order.setCurrentStatus("Deliveried");
            order.setFinishedAt(new Timestamp(System.currentTimeMillis()));
            Dao.getInstance().update(order);
        }catch (Exception e){
            e.toString();
        }
        return true;
    }

    @Override
    public boolean orderCancelled(Order order) {
        try{
            order.setCurrentStatus("Cancelled");
            order.setFinishedAt(new Timestamp(System.currentTimeMillis()));
            Dao.getInstance().update(order);
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

package chain;

import model.Order;
import persistence.Dao;
import states.IOrderState;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrderChain extends IOrderChain implements IOrderState  {

    private static int InitialOrderChainStatus = 0;

    public boolean invoke(Order order) {
        System.out.println("entered create order chain");
        System.out.println("o order.getStatus() = "+order.getStatus());
        System.out.println("The order = " + order);


        try {
            Dao.getInstance().save(order);
            setState(order);
            return checkNext(order);

        }catch(Exception ex)
        {
            System.out.println("Something went wrong " + ex.getMessage());
            return false;
        }

    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as initial");
        order.setStatus(InitialOrderChainStatus);
    }
}
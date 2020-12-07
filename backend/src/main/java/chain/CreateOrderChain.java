package chain;

import model.Order;
import persistence.Dao;

public class CreateOrderChain extends OrderChain {

    public boolean invoke(Order order) {

        try {
            order.updateStatus();
            Dao.getInstance().save(order);
            return checkNext(order);

        }catch(Exception ex)
        {
            return false;
        }

    }
}

package chain;

import model.Order;
import persistence.Dao;
import states.OrderIsCreatedState;

public class CreateOrderChain extends OrderChain {

    public boolean invoke(Order order) {

        try {
            order.setCurrentStatus("Created");
            Dao.getInstance().save(order);
            return checkNext(order);

        }catch(Exception ex)
        {
            return false;
        }

    }
}

package chain;

import model.Order;
import utils.NotificationEmitter;

public class NotifyOrderIsDeliveried extends OrderChain {

    public boolean invoke(Order order) {
        if(order.getStatus() == 3){
            order.updateStatus();
            NotificationEmitter.emit();
            return checkNext(order);
        }
        return false;
    }
}

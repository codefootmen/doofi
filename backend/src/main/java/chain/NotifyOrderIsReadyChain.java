package chain;

import model.Order;
import utils.NotificationEmitter;

public class NotifyOrderIsReadyChain extends OrderChain {

    public boolean invoke(Order order) {

        if(order.getStatus() == 2){
            order.updateStatus();
            NotificationEmitter.emit();
            return checkNext(order);
        }
        return false;
    }
}

package chain;

import model.Order;
import utils.NotificationEmitter;

public class NotifyClientChain extends OrderChain {

    public boolean invoke(Order order) {
        if(order.getStatus() == 1){
            order.updateStatus();
            NotificationEmitter.emit();
            return checkNext(order);
        }
        return false;
    }
}

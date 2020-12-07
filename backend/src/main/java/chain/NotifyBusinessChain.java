package chain;

import model.Order;
import utils.NotificationEmitter;

public class NotifyBusinessChain extends OrderChain {

    public boolean invoke(Order order) {
        if(order.getStatus() == 0){
            order.updateStatus();
            NotificationEmitter.emit();
            return checkNext(order);
        }
        return false;
    }
}

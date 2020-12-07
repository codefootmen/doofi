package chain;

import model.Order;
import utils.NotificationEmitter;

public class NotifyBusinessChain extends OrderChain {

    public boolean invoke(Order order) {
        NotificationEmitter.emit();
        return checkNext(order);
    }
}

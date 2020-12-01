package chain;

import model.Order;
import states.IOrderState;
import utils.NotificationEmitter;

public class NotifyOrderIsDeliveried extends IOrderChain implements IOrderState {

    private static int DeliveredStatus = 4;

    public boolean invoke(Order order) {
        if(order.getStatus() == 3){
            NotificationEmitter.emit();
            setState(order);
            return checkNext(order);
        }
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as delivered");
        order.setStatus(DeliveredStatus);
    }
}

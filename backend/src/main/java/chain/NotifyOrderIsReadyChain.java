package chain;

import model.Order;
import states.IOrderState;
import utils.NotificationEmitter;

public class NotifyOrderIsReadyChain extends IOrderChain implements IOrderState {

    private static int OrderIsReadyStatus = 3;

    public boolean invoke(Order order) {

        if(order.getStatus() == 2){
            NotificationEmitter.emit();
            setState(order);
            return checkNext(order);
        }
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as ready for delivery");
        order.setStatus(OrderIsReadyStatus);
    }
}

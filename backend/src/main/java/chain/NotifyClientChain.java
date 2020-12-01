package chain;

import model.Order;
import states.IOrderState;
import utils.NotificationEmitter;

public class NotifyClientChain extends IOrderChain implements  IOrderState {

    private static int OrderAcceptedByBusinessStatus = 2;

    public boolean invoke(Order order) {
        if(order.getStatus() == 1){
            NotificationEmitter.emit();
            setState(order);
            return checkNext(order);
        }
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as accepted by business");
        order.setStatus(OrderAcceptedByBusinessStatus);
    }
}

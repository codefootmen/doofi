package chain;

import model.Order;
import states.IOrderState;
import utils.NotificationEmitter;

public class NotifyClientChain extends IOrderChain implements  IOrderState {

    private static int OrderAcceptedByBusinessStatus = 2;

    public boolean invoke(Order order) {
        System.out.println("entered notify client");
        System.out.println("current order status" + order.getStatus());
        boolean validation = order.getStatus() == 1;
        if(order.getStatus() == 1){
            System.out.println("validation result = " + validation);
            NotificationEmitter.emit();
            setState(order);
            return checkNext(order);
        }
        System.out.println("Validation went wrong on notify client");
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as accepted by business");
        order.setStatus(OrderAcceptedByBusinessStatus);
    }
}

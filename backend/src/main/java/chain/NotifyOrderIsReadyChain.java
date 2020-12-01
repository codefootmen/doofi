package chain;

import model.Order;
import states.IOrderState;

public class NotifyOrderIsReadyChain extends IOrderChain implements IOrderState {

    private static int OrderIsReadyStatus = 3;

    public boolean invoke(Order order) {
        System.out.println("entered order is ready");
        System.out.println("order status is "+order.getStatus());
        if(order.getStatus() == 2){
            System.out.println("validation is ok");
            //Todo: send notification
            setState(order);
            return checkNext(order);
        }
        System.out.println("validation went wrong");
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as ready for delivery");
        order.setStatus(OrderIsReadyStatus);
    }
}

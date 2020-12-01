package chain;

import model.Order;
import states.IOrderState;

public class NotifyOrderIsDeliveried extends IOrderChain implements IOrderState {

    private static int DeliveredStatus = 4;

    public boolean invoke(Order order) {
        System.out.println("entered notify order is delivered");
        System.out.println("order status now is "+order.getStatus());
        if(order.getStatus() == 3){
            System.out.println("Validation is ok");
            //Todo: send notification
            setState(order);
            return checkNext(order);
        }
        System.out.println("validation went wrong");
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as delivered");
        order.setStatus(DeliveredStatus);
    }
}

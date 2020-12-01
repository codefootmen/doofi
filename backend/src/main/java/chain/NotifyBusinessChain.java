package chain;

import model.Order;
import states.IOrderState;

public class NotifyBusinessChain extends IOrderChain implements IOrderState {

    private static int ExpectBusinessToAcceptOrderStatus = 1;

    public boolean invoke(Order order) {
        System.out.println("entered notify business accept order");
        System.out.println("The current Status is "+order.getStatus());
        boolean validation = order.getStatus() == 0;
        if(order.getStatus() == 0){
            System.out.println("The validation gave response" + validation);
            //Todo: send notification
            setState(order);
            return checkNext(order);
        }
        System.out.println("validation went wrong on notify business");
        return false;
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as expect business to accept order");
        order.setStatus(ExpectBusinessToAcceptOrderStatus);
    }
}

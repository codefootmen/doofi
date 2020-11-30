package chain;

import model.Order;
import states.IOrderState;

public class NotifyOrderIsDeliveried implements IOrderState, IOrderChain {
    private IOrderChain chain;
    private static int DeliveredStatus = 4;

    @Override
    public void setNextChain(IOrderChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void Invoke(Order order) {
        if(order.getStatus() == 3){
            //Todo: send notification
            setState(order);
        }
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as delivered");
        order.setStatus(DeliveredStatus);
    }
}

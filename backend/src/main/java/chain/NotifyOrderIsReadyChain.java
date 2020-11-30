package chain;

import model.Order;
import states.IOrderState;

public class NotifyOrderIsReadyChain implements IOrderState, IOrderChain {
    private IOrderChain chain;
    private static int OrderIsReadyStatus = 3;

    @Override
    public void setNextChain(IOrderChain nextChain)
    {
        this.chain = nextChain;
    }

    @Override
    public void Invoke(Order order) {
        if(order.getStatus() == 2){
            //Todo: send notification
            setState(order);
        }
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as ready for delivery");
        order.setStatus(OrderIsReadyStatus);
    }
}

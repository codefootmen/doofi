package chain;

import model.Order;
import states.IOrderState;

public class NotifyBusinessChain implements IOrderState, IOrderChain {
    private IOrderChain chain;
    private static int ExpectBusinessToAcceptOrderStatus = 1;

    @Override
    public void setNextChain(IOrderChain nextChain)
    {
        this.chain = nextChain;
    }

    @Override
    public void Invoke(Order order) {
        if(order.getStatus() == 0){
            //Todo: send notification
            setState(order);
        }
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as expect business to accept order");
        order.setStatus(ExpectBusinessToAcceptOrderStatus);
    }
}

package chain;

import model.Order;
import states.IOrderState;

public class NotifyClientChain implements  IOrderState, IOrderChain {

    private IOrderChain chain;
    private static int OrderAcceptedByBusinessStatus = 2;

    @Override
    public void setNextChain(IOrderChain nextChain) {

        this.chain = nextChain;
    }

    @Override
    public void Invoke(Order order) {
        if(order.getStatus() == 1){
            //Todo: send notification
            setState(order);
        }
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as accepted by business");
        order.setStatus(OrderAcceptedByBusinessStatus);
    }
}

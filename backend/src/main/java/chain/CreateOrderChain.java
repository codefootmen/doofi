package chain;

import model.Order;
import persistence.Dao;
import states.IOrderState;

public class CreateOrderChain implements IOrderState, IOrderChain {
    private IOrderChain chainData;
    private static int InitialOrderChainStatus = 0;

    @Override
    public void setNextChain(IOrderChain nextChain) {
        this.chainData = nextChain;
    }

    @Override
    public void Invoke(Order order) {
        if(order.getStatus() == null) {
            Dao.getInstance().save(order);
            setState(order);
        }
    }

    @Override
    public void setState(Order order) {
        System.out.println("Status set as initial");
        order.setStatus(InitialOrderChainStatus);
    }
}

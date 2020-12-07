package chain;

import model.Order;

public abstract class OrderChain
{
    private OrderChain next;

    public OrderChain setNextChain(OrderChain next) {
        this.next = next;
        return next;
    }

    public abstract boolean invoke(Order order);

    protected boolean checkNext(Order order) {
        if (next == null) {
            return true;
        }
        return next.invoke(order);
    }
}
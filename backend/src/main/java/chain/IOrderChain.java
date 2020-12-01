package chain;

import model.Order;

import java.text.ParseException;

public abstract class IOrderChain
{
    private IOrderChain next;

    public IOrderChain setNextChain(IOrderChain next) {
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
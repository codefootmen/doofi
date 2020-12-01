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
        System.out.println("entered next check");
        System.out.println("The order is = " + order);
        System.out.println("The next one = " + next);
        if (next == null) {
            return true;
        }
        return next.invoke(order);
    }
}
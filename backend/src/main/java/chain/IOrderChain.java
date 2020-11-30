package chain;

import model.Order;

public interface IOrderChain
{
    void setNextChain(IOrderChain nextChain);

    void Invoke(Order order);
}
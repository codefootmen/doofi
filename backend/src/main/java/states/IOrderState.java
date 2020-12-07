package states;

import model.Order;

public interface IOrderState
{
    boolean orderCreated (Order order);
    boolean orderAccepted (Order order);
    boolean orderSent (Order order);
    boolean orderDeliveried (Order order);
    boolean orderCancelled (Order order);

    String getState();

}

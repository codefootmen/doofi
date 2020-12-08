package actions;

import chain.*;
import com.google.gson.Gson;
import lombok.SneakyThrows;


import model.BagManager;
import model.Order;

public class MakeOrderAction implements ICommand {

    private Order order = Order.builder().build();
    private Gson gson = new Gson();
    OrderChain orderChain = new CreateOrderChain();

    public MakeOrderAction() {
        orderChain.setNextChain(new NotifyBusinessChain())
                .setNextChain(new NotifyClientChain())
                .setNextChain(new NotifyOrderIsReadyChain())
                .setNextChain(new NotifyOrderIsDeliveried());
    }

    @SneakyThrows
    @Override
    public Object execute(String req, int id) {
        MakeOrderAction makeOrderAction = new MakeOrderAction();

        Order newOrder = gson.fromJson(req, order.getClass());

        BagManager.bag.addOrder(newOrder);
        BagManager.bag.snapshot();

        return makeOrderAction.orderChain.invoke(newOrder);
    }
}

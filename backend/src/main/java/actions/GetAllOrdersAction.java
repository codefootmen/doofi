package actions;

import model.BagManager;
import model.Client;
import model.Order;
import persistence.Dao;

import java.util.ArrayList;
import java.util.List;

public class GetAllOrdersAction implements ICommand {

    @Override
    public Object execute(String req, int id) {
        Order order = Order.builder().build();

        List<Order> orderList = Dao.getInstance().getAll(order);

        BagManager.bag.setOrders((ArrayList<Order>) orderList);
        BagManager.bag.snapshot();

        return orderList;
    }
}

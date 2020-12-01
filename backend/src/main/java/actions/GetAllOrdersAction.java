package actions;

import model.Client;
import model.Order;
import persistence.Dao;

import java.util.List;

public class GetAllOrdersAction implements ICommand {

    @Override
    public Object execute(String req, int id) {
        Order order = new Order();

        List<Order> orderList = Dao.getInstance().getAll(order);

        return orderList;
    }
}

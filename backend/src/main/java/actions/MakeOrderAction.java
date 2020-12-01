package actions;

import chain.*;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Order;
import model.web_api_response.WebApiResponse;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeOrderAction implements ICommand{

    private Order order = new Order();
    private Gson gson = new Gson();
    IOrderChain orderChain = new CreateOrderChain();

    public MakeOrderAction(){
        orderChain.setNextChain(new NotifyBusinessChain())
                .setNextChain(new NotifyClientChain())
                .setNextChain(new NotifyOrderIsReadyChain())
                .setNextChain(new NotifyOrderIsDeliveried());
    }

    @SneakyThrows
    @Override
    public Object execute(String req, int id) {
        System.out.println("entered make order execute");
        MakeOrderAction makeOrderAction = new MakeOrderAction();

        Order newOrder = gson.fromJson(req, order.getClass());

        System.out.println();

        System.out.println("new order = " + newOrder);

        return makeOrderAction.orderChain.invoke(newOrder);
    }
}

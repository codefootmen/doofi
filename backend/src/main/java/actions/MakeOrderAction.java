package actions;

import chain.*;
import com.google.gson.Gson;
import model.Order;
import model.web_api_response.WebApiResponse;

public class MakeOrderAction implements ICommand{

    private Order order = new Order();
    private IOrderChain createOrderChain;
    private Gson gson = new Gson();

    public MakeOrderAction(){
        //init chain
        this.createOrderChain = new CreateOrderChain();
        IOrderChain notifyBusinessChain = new NotifyBusinessChain();
        IOrderChain notifyClientChain = new NotifyClientChain();
        IOrderChain notifyOrderIsReadyChain = new NotifyOrderIsReadyChain();
        IOrderChain notifyOrderIsDeliveredChain = new NotifyOrderIsDeliveried();

        //set the chain of responsability
        createOrderChain.setNextChain(notifyBusinessChain);
        notifyBusinessChain.setNextChain(notifyClientChain);
        notifyClientChain.setNextChain(notifyOrderIsReadyChain);
        notifyOrderIsReadyChain.setNextChain(notifyOrderIsDeliveredChain);

    }

    @Override
    public Object execute(String req, int id) {
        MakeOrderAction makeOrderAction = new MakeOrderAction();

        Order newOrder = gson.fromJson(req, order.getClass());
        try {
            makeOrderAction.createOrderChain.Invoke(newOrder);
        }catch(Exception ex){
            return new WebApiResponse(false, null, ex.getMessage());
        }

        return new WebApiResponse(true, null, null);

    }
}

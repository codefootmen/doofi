package cross_cutting.ioc;

import actions.BusinessAction;
import actions.ClientAction;

import javax.ws.rs.ApplicationPath;

import controller.PaymentController;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Setup extends ResourceConfig  {
    public Setup(){
        registerClasses(ClientAction.class);
        registerClasses(PaymentController.class);
        registerClasses(BusinessAction.class);
    }
}


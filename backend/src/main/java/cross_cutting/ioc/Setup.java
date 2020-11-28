package cross_cutting.ioc;

import controller.BusinessController;
import controller.ClientController;
import javax.ws.rs.ApplicationPath;

import controller.PaymentController;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Setup extends ResourceConfig  {
    public Setup(){
        registerClasses(ClientController.class);
        registerClasses(PaymentController.class);
        registerClasses(BusinessController.class);
    }
}


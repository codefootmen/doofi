package cross_cutting.ioc;

import javax.ws.rs.ApplicationPath;

import controller.FrontController;
import controller.PaymentController;
import org.glassfish.jersey.server.ResourceConfig;
import utils.NotificationEmitter;
import utils.NotificationObserver;

@ApplicationPath("/")
public class Setup extends ResourceConfig  {
    public Setup(){
        registerClasses(PaymentController.class);
        registerClasses(FrontController.class);

        NotificationEmitter.addObserver(new NotificationObserver());
    }
}


package cross_cutting.ioc;

import controller.ClientController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Setup extends ResourceConfig  {
    public Setup(){
         registerClasses(ClientController.class);
    }
}


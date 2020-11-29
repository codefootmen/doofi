package actions;

import model.Client;
import persistence.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/client/")
public class ClientAction {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "It's Working!!!";
    }

    @GET
    @Path("{id}/")
    public String getObjectById(@PathParam("id") int id) {
        try{
            Optional<Client> client = Dao.getInstance().get(new Client(), id);
            if(client.isPresent())
                return client.get().getName();
        }
        catch (Exception e){
            return e.toString();
        }
        return "There is no client with this id";
    }
}

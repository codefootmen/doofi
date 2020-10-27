package controller;

import model.Client;
import persistence.Dao;
import utils.ClientValidationHelper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/client/")
public class ClientController {
    
      @GET
      @Produces(MediaType.TEXT_PLAIN)
      public String index(){
          return "It's Working!!!";
      }

//    public void CreateClient (Client client) throws Exception
//    {
//        boolean validation = ClientValidationHelper.getInstance().ValidateClient(client);
//
//        if(!validation){
//            throw new Exception("Client not valid!");
//        }
//        else {
//            Dao.getInstance().save(client);
//        }
//        //In theory we need to return a view from here
//    }
//
//    public void DeleteClient(Client client)
//    {
//        Dao.getInstance().delete(client); // I think that thing needs the Id
//    }
//
//    public void UpdateClient(Client client) throws Exception {
//        // well i kinda don't know what is better, maybe I will make a override to check String[], but I will wait
//        // until DAO is fully implemented to change
//        boolean validation = ClientValidationHelper.getInstance().ValidateClient(client);
//
//        if(!validation){
//            throw new Exception("Client not valid!");
//        }
//        else {
//            Dao.getInstance().update(client);
//        }
//        //In theory we need to return a view from here
//    }
//
//    @Produces(MediaType.TEXT_PLAIN)

    @GET
    @Path("{id}/")
    public String getClient(@PathParam("id") String id)
    {
        try{
            Optional<Client> client = Dao.getInstance().get(new Client(), Long.parseLong(id));
            if(client.isPresent())
                return client.get().getName();
        }
        catch (Exception e){
            return e.toString();
        }
        return "There is no client with this id";
    }
//
//    public void ReadAllClients(Client client){
//        Dao.getInstance().getAll(client);
//    }
}

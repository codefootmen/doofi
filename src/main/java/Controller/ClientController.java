package Controller;

import Model.Client;
import Persistence.Dao;
import Utils.ClientValidationHelper;

public class ClientController {

    public void CreateClient (Client client) throws Exception
    {
        boolean validation = ClientValidationHelper.getInstance().ValidateClient(client);

        if(!validation){
            throw new Exception("Client not valid!");
        }
        else {
            Dao.getInstance().save(client);
        }
        //In theory we need to return a view from here
    }

    public void DeleteClient(Client client)
    {
        Dao.getInstance().delete(client); // I think that thing needs the Id
    }

    public void UpdateClient(Client client) throws Exception {
        // well i kinda don't know what is better, maybe I will make a override to check String[], but I will wait
        // until DAO is fully implemented to change
        boolean validation = ClientValidationHelper.getInstance().ValidateClient(client);

        if(!validation){
            throw new Exception("Client not valid!");
        }
        else {
            Dao.getInstance().update(client);
        }
        //In theory we need to return a view from here
    }

    public void ReadClient(Client client)
    {
        Dao.getInstance().get(client, client.getClientId());
        //WIP
    }

    public void ReadAllClients(Client client){
        Dao.getInstance().getAll(client);
    }
}

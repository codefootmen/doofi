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
        Dao.getInstance().delete(client);
    }

    public void UpdateClient(Client client, String[] changeParams) throws Exception {
        // well i kinda don't know what is better, maybe I will make a override to check String[], but I will wait
        // until DAO is fully implemented to change
        boolean validation = ClientValidationHelper.getInstance().ValidateClient(client);

        if(!validation){
            throw new Exception("Client not valid!");
        }
        else {
            Dao.getInstance().update(client, changeParams);
        }
        //In theory we need to return a view from here
    }

    public void ReadClient(Client client)
    {
        Dao.getInstance().get(client, client.getClientId());
        //WIP
    }
}

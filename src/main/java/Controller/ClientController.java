package Controller;

import Model.Address;
import Model.Client;
import Persistence.Dao;
import Utils.ClientValidationHelper;
import Utils.IClientValidationHelper;

public class ClientController {

    private IClientValidationHelper clientValidation;

    public ClientController(IClientValidationHelper clientValidationHelper)
    {
        if(clientValidationHelper == null) throw new NullPointerException("Client validation helper");
        this.clientValidation = clientValidationHelper;
    }

    public void CreateClient (Client client) throws Exception
    {
        boolean validation = clientValidation.ValidateClient(client);

        if(!validation){
            throw new Exception("Client not valid!");
        }
        else {
            // save from DAO
        }

        //In theory we need to return a view from here
    }

    public void DeleteClient(long clientId)
    {
        //Delete from DAO
        //and return view
    }
    public void UpdateClient()
    {

    }
}

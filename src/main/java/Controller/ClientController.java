package Controller;

import Model.Address;
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

    public void CreateClient (String name, String cpf, String login, String password, Address address) throws Exception {
        var validation = clientValidation.ValidateClient(name, cpf, login, password);

        if(!validation){
            throw new Exception("Client not valid!");
        }
        else {
            Dao.Save(name, cpf, login, password, address);
        }

    }
}

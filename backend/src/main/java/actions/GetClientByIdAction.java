package actions;

import model.Client;
import persistence.Dao;

public class GetClientByIdAction implements ICommand{

    @Override
    public Object execute(String req, int id) {
        Client client = Client.builder().build();

        try{
            return Dao.getInstance().get(client, id);
        }
        catch (Exception ex){
            return ex.toString();
        }
    }
}

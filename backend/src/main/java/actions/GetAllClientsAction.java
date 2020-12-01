package actions;

import model.Client;
import persistence.Dao;

import java.util.List;

public class GetAllClientsAction implements ICommand {

    @Override
    public Object execute(String req, int id) {
        Client client = Client.builder().build();

        List<Client> clientList = Dao.getInstance().getAll(client);

        return clientList;
    }
}

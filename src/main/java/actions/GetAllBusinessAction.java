package actions;

import com.google.gson.Gson;
import model.Business;
import persistence.Dao;

import java.util.List;

public class GetAllBusinessAction implements ICommand {

    @Override
    public Object execute(String req, int id) {
        Business business = new Business();

        List<Business> businessList = Dao.getInstance().getAll(business);

        return businessList;
    }
}

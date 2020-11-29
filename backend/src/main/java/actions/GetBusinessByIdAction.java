package actions;

import com.google.gson.Gson;
import model.Business;
import persistence.Dao;

public class GetBusinessByIdAction implements ICommand{

    @Override
    public Object execute(String req, int id) {
        Business business = new Business();

        try{
            return Dao.getInstance().get(business, id);
        }
        catch (Exception ex){
            return ex.toString();
        }
    }
}

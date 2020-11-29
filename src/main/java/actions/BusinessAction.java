package actions;

import com.google.gson.Gson;
import model.Business;
import persistence.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/business/")
public class BusinessAction {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index()
    {
        Business business = new Business();
        Gson gson = new Gson();

        List<Business> businessList = Dao.getInstance().getAll(business);

        return gson.toJson(businessList);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getBusiness/{id}/")
    public String getObjectById(@PathParam("id") int id)
    {
        Business business = new Business();
        Gson gson = new Gson();

        try{
            return gson.toJson(Dao.getInstance().get(business,id));
        }
        catch (Exception ex){
            return ex.toString();
        }
    }
}

package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.Business;
import model.Business.*;
import persistence.Dao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/business/")
public class BusinessController {

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
    public String getBusinessById(@PathParam("id") int id)
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createBusiness")
    public String saveBusiness(JsonObject object)
    {
        Gson gson = new Gson();

        try{
            Business business = gson.fromJson(object, Business.class);
            Dao.getInstance().save(business);
        }
        catch (Exception ex){
            return ex.toString();
        }
        return "Yeah it did went well";
    }

}

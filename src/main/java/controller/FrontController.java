package controller;

import actions.ICommand;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import model.Business;
import model.web_api_response.WebApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/front/")
public class FrontController {

    private static Gson gson = new Gson();

    @SneakyThrows
    protected WebApiResponse handleRequest(String req)
    {
        ICommand command = null;

        try
        {
            command = (ICommand) Class.forName("actions."+req).getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Object response = command.execute(req);

            return new WebApiResponse(true,response,null);
        }catch (Exception e)
        {
            return new WebApiResponse(false,null,e.getMessage());
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/{command}")
    public String get(@PathParam("command") String req)
    {
        return gson.toJson(handleRequest(req));
    }
}

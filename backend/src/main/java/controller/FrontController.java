package controller;

import actions.ICommand;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.web_api_response.WebApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/front/")
public class FrontController {

    private static Gson gson = new Gson();

    @SneakyThrows
    protected WebApiResponse handleRequest(String req, int id)
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
            Object response = command.execute(req, id);

            return new WebApiResponse(true,response,null);
        }catch (Exception e)
        {
            return new WebApiResponse(false,null,e.getMessage());
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/{command}/{id}")
    public String get(@PathParam("command") String req, @PathParam("id") int id)
    {
        return gson.toJson(handleRequest(req,id));
    }
}

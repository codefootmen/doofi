package controller;

import actions.ICommand;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.web_api_response.WebApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/action/")
public class FrontController {

    private static Gson gson = new Gson();

    @SneakyThrows
    protected WebApiResponse handleRequest(String req, int id)
    {
        try
        {
            ICommand command = (ICommand) Class.forName("actions."+req).getDeclaredConstructor().newInstance();
            Object response = command.execute(req, id);

            return new WebApiResponse(true,response,null);
        }catch (Exception e)
        {
            return new WebApiResponse(false,null,e.getMessage());
        }
    }


    @SneakyThrows
    protected WebApiResponse handleRequest(String command, String req)
    {
        try
        {
            ICommand action = (ICommand) Class.forName("actions."+command).getDeclaredConstructor().newInstance();
            Object response = action.execute(req, 0);

            return new WebApiResponse(true,response,null);
        }catch (Exception e)
        {
            return new WebApiResponse(false,null,e.getMessage());
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{command}/{id}")
    public String get(@PathParam("command") String req, @PathParam("id") int id)
    {
        return gson.toJson(handleRequest(req,id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{command}/")
    public String get(@PathParam("command") String req)
    {
        return gson.toJson(handleRequest(req, 0));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{command}/")
    public String post(@PathParam("command") String command, @FormParam("value") String req )
    {
         return gson.toJson(handleRequest(command, req));
    }
}

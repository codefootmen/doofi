package controller;

import actions.ICommand;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.web_api_response.WebApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/action/")
public class FrontController {

    private static Gson gson = new Gson();

    @SneakyThrows
    public Response handleRequest(String req, int id) {
        try {
            ICommand command = (ICommand) Class.forName("actions." + req).getDeclaredConstructor().newInstance();
            Object response = command.execute(req, id);

//            response.getHeaders().add("Access-Control-Allow-Origin", "*");
//            response.getHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
//            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
//            response.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
//

            Gson gs = new Gson();
            return Response.status(200).entity(gs.toJson(response))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD")
                    .build();
        } catch (Exception e) {
            return Response.status(500).header("Access-Control-Allow-Origin", "*").build();
        }
    }


    @SneakyThrows
    public Response handleRequest(String command, String req) {
        try {
            ICommand action = (ICommand) Class.forName("actions." + command).getDeclaredConstructor().newInstance();
            Object response = action.execute(req, 0);

            Gson gs = new Gson();
            return Response.status(200).entity(gs.toJson(response))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD")
                    .build();
        } catch (Exception e) {
            return Response.status(500).header("Access-Control-Allow-Origin", "*").build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{command}/{id}")
    public Response get(@PathParam("command") String req, @PathParam("id") int id) {
        Response response = handleRequest(req, id);
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{command}/")
    public Response get(@PathParam("command") String req) {
        return handleRequest(req, 0);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{command}/")
    public Response post(@PathParam("command") String command, @FormParam("value") String req) {
        return handleRequest(command, req);
    }
}

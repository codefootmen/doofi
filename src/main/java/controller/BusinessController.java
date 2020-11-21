package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.Business;
import model.Business.*;
import persistence.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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


//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("creditcard/{amount}/")
//    public String makePaymentWithCreditCard(@PathParam("amount") int amount) {
//        IPayStrategy payment = new CreditCardPayment(new CreditCard("123", "04/20", "999"));
//        if (payment.pay(amount))
//            return "Paid US$ " + amount + " with Credit Card!";
//
//        return "Error";
//    }
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("paypal/{amount}/")
//    public String makePaymentWithPayPal(@PathParam("amount") int amount) {
//        IPayStrategy payment = new PayPalPayment(new PayPalAccount("123", "04/20", true));
//        if (payment.pay(amount))
//            return "Paid US$ " + amount + " with PayPal!";
//
//        return "Error";
//    }
}

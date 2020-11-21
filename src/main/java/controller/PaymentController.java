package controller;

import model.payments.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/payment/")
public class PaymentController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Choose your payment method!";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("creditcard/{amount}/")
    public String makePaymentWithCreditCard(@PathParam("amount") int amount) {
        IPayStrategy payment = new CreditCardPayment(new CreditCard("123", "04/20", "999"));
        if(payment.pay(amount))
            return "Paid US$ " + amount +" with Credit Card!";

        return "Error";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("paypal/{amount}/")
    public String makePaymentWithPayPal(@PathParam("amount") int amount) {
        IPayStrategy payment = new PayPalPayment(new PayPalAccount("123", "04/20", true));
        if(payment.pay(amount))
            return "Paid US$ " + amount + " with PayPal!";

        return "Error";
    }
}

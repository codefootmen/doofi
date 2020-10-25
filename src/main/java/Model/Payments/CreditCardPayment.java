package Model.Payments;

public class CreditCardPayment implements  IPayStrategy {

    private CreditCard creditCard;

    public CreditCardPayment(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean pay(int paymentAmount) {
        // Make the payment
        return true;
    }
}

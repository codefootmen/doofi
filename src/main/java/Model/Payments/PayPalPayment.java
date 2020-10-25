package Model.Payments;

public class PayPalPayment implements IPayStrategy{

    private PayPalAccount payPalAccount;

    public PayPalPayment(PayPalAccount payPalAccount) {
        this.payPalAccount = payPalAccount;
    }

    @Override
    public boolean pay(int paymentAmount) {
        // Make the payment
        return true;
    }
}

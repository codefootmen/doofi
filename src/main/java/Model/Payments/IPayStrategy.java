package Model.Payments;

public interface IPayStrategy {
    boolean pay(int paymentAmount);
}

package model.payments;

public interface IPayStrategy {
    boolean pay(int paymentAmount);
}

package model.payments;

import lombok.Data;

@Data
public class PayPalAccount {
    private String email;
    private String password;
    private boolean signedIn;

    public PayPalAccount(String email, String password, boolean signedIn) {
        this.email = email;
        this.password = password;
        this.signedIn = signedIn;
    }
}

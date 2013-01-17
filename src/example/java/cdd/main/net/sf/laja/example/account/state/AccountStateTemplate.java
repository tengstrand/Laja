package net.sf.laja.example.account.state;

public class AccountStateTemplate {
    double balance; // (key)

    public boolean isValid() {
        return balance >= 0;
    }
}

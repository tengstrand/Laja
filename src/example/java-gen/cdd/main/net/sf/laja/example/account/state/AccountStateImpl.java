package net.sf.laja.example.account.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AccountStateImpl implements AccountState {
    protected double balance;

    private boolean _encapsulated = false;

    AccountStateImpl() {
    }

    public AccountStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static AccountStateBuilder build() {
        return new AccountStateBuilderImpl();
    }

    public static AccountStateBuilder build(AccountState state) {
        return new AccountStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        return balance >= 0;
    }

    // Getters
    public double getBalance() { return balance; }

    // Setters
    public void setBalance(double balance) { this.balance = balance; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStateImpl state = (AccountStateImpl)o;

        if (balance != state.getBalance()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStateImpl state = (AccountStateImpl)o;

        if (balance != state.getBalance()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)balance;

        return result;
    }

    public int valueHashCode() {
        int result = (int)balance;

        return result;
    }

    @Override
    public String toString() {
        return "{balance=" + balance + "}";
    }
}

package net.sf.laja.example.account.state;

import java.util.ArrayList;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AccountStateListImpl extends ArrayList<AccountState> implements AccountStateList {
    private boolean _encapsulated = false;

    public AccountStateListImpl() {
    }

    public AccountStateListImpl(int size) {
        super(size);
    }

    public static AccountStateList emptyList() {
        return new AccountStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (AccountState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (AccountState state : this) {
            state.encapsulate();
        }
    }
}

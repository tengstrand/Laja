package net.sf.laja.example.account.state;

import net.sf.laja.example.account.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface AccountStateBuilder {
    void withBalance(double balance);
    boolean isValid();
    Object as(AccountStateBehaviourFactory factory, Object... args);
    AccountState getAccountState(net.sf.laja.example.account.state.Certificate certificate);
}

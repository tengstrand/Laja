package net.sf.laja.example.account.state;

import java.util.List;
import net.sf.laja.example.account.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface AccountStateList extends List<AccountState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}

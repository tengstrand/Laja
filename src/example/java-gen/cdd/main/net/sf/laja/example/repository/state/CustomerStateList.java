package net.sf.laja.example.repository.state;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface CustomerStateList extends List<CustomerState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}

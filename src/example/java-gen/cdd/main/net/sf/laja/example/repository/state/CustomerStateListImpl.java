package net.sf.laja.example.repository.state;

import java.util.*;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class CustomerStateListImpl extends ArrayList<CustomerState> implements CustomerStateList {
    private boolean _encapsulated = false;

    public CustomerStateListImpl() {
    }

    public static CustomerStateList emptyList() {
        return new CustomerStateListImpl();
    }

    public boolean isValid() {
        for (CustomerState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (CustomerState state : this) {
            state.encapsulate();
        }
    }
}

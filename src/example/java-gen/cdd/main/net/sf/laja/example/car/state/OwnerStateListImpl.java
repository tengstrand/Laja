package net.sf.laja.example.car.state;

import java.util.*;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OwnerStateListImpl extends ArrayList<OwnerState> implements OwnerStateList {
    private boolean _encapsulated = false;

    public OwnerStateListImpl() {
    }

    public OwnerStateListImpl(int size) {
        super(size);
    }

    public static OwnerStateList emptyList() {
        return new OwnerStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (OwnerState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (OwnerState state : this) {
            state.encapsulate();
        }
    }
}

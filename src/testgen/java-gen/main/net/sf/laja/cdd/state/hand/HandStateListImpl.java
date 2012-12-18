package net.sf.laja.cdd.state.hand;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HandStateListImpl extends ArrayList<HandState> implements HandStateList {
    private boolean _encapsulated = false;

    public HandStateListImpl() {
    }

    public HandStateListImpl(int size) {
        super(size);
    }

    public static HandStateList emptyList() {
        return new HandStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (HandState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (HandState state : this) {
            state.encapsulate();
        }
    }
}

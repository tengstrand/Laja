package net.sf.laja.example.person.state;

import java.util.*;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HeightStateListImpl extends ArrayList<HeightState> implements HeightStateList {
    private boolean _encapsulated = false;

    public HeightStateListImpl() {
    }

    public static HeightStateList emptyList() {
        return new HeightStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (HeightState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (HeightState state : this) {
            state.encapsulate();
        }
    }
}

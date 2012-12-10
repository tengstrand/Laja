package net.sf.laja.cdd.state.animal;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class AnimalStateListImpl extends ArrayList<AnimalState> implements AnimalStateList {
    private boolean _encapsulated = false;

    public AnimalStateListImpl() {
    }

    public static AnimalStateList emptyList() {
        return new AnimalStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (AnimalState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (AnimalState state : this) {
            state.encapsulate();
        }
    }
}

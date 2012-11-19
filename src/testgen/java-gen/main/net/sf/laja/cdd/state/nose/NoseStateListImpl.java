package net.sf.laja.cdd.state.nose;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class NoseStateListImpl extends ArrayList<NoseState> implements NoseStateList {
    private boolean _encapsulated = false;

    public NoseStateListImpl() {
    }

    public static NoseStateList emptyList() {
        return new NoseStateListImpl();
    }

    public boolean isValid() {
        for (NoseState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (NoseState state : this) {
            state.encapsulate();
        }
    }
}

package net.sf.laja.cdd.state.leg;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class LegStateListImpl extends ArrayList<LegState> implements LegStateList {
    private boolean _encapsulated = false;

    public LegStateListImpl() {
    }

    public static LegStateList emptyList(Certificate certificate) {
        return new LegStateListImpl();
    }

    public boolean isValid() {
        for (LegState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (LegState state : this) {
            state.encapsulate();
        }
    }
}

package net.sf.laja.cdd.state.forehead;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ForeheadStateListImpl extends ArrayList<ForeheadState> implements ForeheadStateList {
    private boolean _encapsulated = false;

    public ForeheadStateListImpl() {
    }

    public static ForeheadStateList emptyList(Certificate certificate) {
        return new ForeheadStateListImpl();
    }

    public boolean isValid() {
        for (ForeheadState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (ForeheadState state : this) {
            state.encapsulate();
        }
    }
}

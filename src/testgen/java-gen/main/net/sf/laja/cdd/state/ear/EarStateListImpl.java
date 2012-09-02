package net.sf.laja.cdd.state.ear;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class EarStateListImpl extends ArrayList<EarState> implements EarStateList {
    private boolean _encapsulated = false;

    EarStateListImpl() {
    }

    public static EarStateList emptyList(Certificate certificate) {
        return new EarStateListImpl();
    }

    public boolean isValid() {
        for (EarState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (EarState state : this) {
            state.encapsulate();
        }
    }
}

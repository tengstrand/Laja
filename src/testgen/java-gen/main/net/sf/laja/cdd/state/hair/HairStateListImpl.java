package net.sf.laja.cdd.state.hair;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HairStateListImpl extends ArrayList<HairState> implements HairStateList {
    private boolean _encapsulated = false;

    HairStateListImpl() {
    }

    public static HairStateList emptyList(Certificate certificate) {
        return new HairStateListImpl();
    }

    public boolean isValid() {
        for (HairState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (HairState state : this) {
            state.encapsulate();
        }
    }
}

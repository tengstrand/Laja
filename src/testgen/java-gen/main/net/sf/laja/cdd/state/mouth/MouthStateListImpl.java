package net.sf.laja.cdd.state.mouth;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MouthStateListImpl extends ArrayList<MouthState> implements MouthStateList {
    private boolean _encapsulated = false;

    MouthStateListImpl() {
    }

    public static MouthStateList emptyList(Certificate certificate) {
        return new MouthStateListImpl();
    }

    public boolean isValid() {
        for (MouthState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (MouthState state : this) {
            state.encapsulate();
        }
    }
}

package net.sf.laja.example.repository.state;

import java.util.*;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ZipcodeStateListImpl extends ArrayList<ZipcodeState> implements ZipcodeStateList {
    private boolean _encapsulated = false;

    public ZipcodeStateListImpl() {
    }

    public static ZipcodeStateList emptyList() {
        return new ZipcodeStateListImpl();
    }

    public boolean isValid() {
        for (ZipcodeState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (ZipcodeState state : this) {
            state.encapsulate();
        }
    }
}

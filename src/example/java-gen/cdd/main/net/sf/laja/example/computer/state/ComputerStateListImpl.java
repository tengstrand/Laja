package net.sf.laja.example.computer.state;

import java.util.*;
import net.sf.laja.example.computer.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ComputerStateListImpl extends ArrayList<ComputerState> implements ComputerStateList {
    private boolean _encapsulated = false;

    public ComputerStateListImpl() {
    }

    public static ComputerStateList emptyList() {
        return new ComputerStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (ComputerState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (ComputerState state : this) {
            state.encapsulate();
        }
    }
}

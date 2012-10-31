package net.sf.laja.example.person.state;

import java.util.*;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class PersonStateListImpl extends ArrayList<PersonState> implements PersonStateList {
    private boolean _encapsulated = false;

    public PersonStateListImpl() {
    }

    public static PersonStateList emptyList(Certificate certificate) {
        return new PersonStateListImpl();
    }

    public boolean isValid() {
        for (PersonState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (PersonState state : this) {
            state.encapsulate();
        }
    }
}

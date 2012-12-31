package net.sf.laja.example.person.state;

import java.util.*;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class PersonStateListImpl extends ArrayList<PersonState> implements PersonStateList {
    private Object encapsulator;

    public PersonStateListImpl() {
    }

    public PersonStateListImpl(int size) {
        super(size);
    }

    public static PersonStateList emptyList() {
        return new PersonStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (PersonState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate(Object encapsulator) {
        this.encapsulator = encapsulator;
    }

    public void throwExceptionIfNotEncapsulatedBy(Object encapsulator) {
        if (encapsulator != this.encapsulator) {
            throw new IllegalStateException("The state has been encapsulated by an instance of " + this.encapsulator.getClass().getSimpleName() + " and can not be operated by " + encapsulator.getClass().getSimpleName());
        }
    }
}

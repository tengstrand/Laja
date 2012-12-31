package net.sf.laja.example.file.state;

import java.util.*;
import net.sf.laja.example.file.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class DirectoryStateListImpl extends ArrayList<DirectoryState> implements DirectoryStateList {
    private Object encapsulator;

    public DirectoryStateListImpl() {
    }

    public DirectoryStateListImpl(int size) {
        super(size);
    }

    public static DirectoryStateList emptyList() {
        return new DirectoryStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (DirectoryState state : this) {
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

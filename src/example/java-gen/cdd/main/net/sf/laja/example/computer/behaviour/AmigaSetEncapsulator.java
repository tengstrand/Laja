package net.sf.laja.example.computer.behaviour;

import java.util.*;
import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaSetEncapsulator implements Iterable<AmigaEncapsulator> {
    public ComputerStateSetBuilder stateSetBuilder = new ComputerStateSetBuilder();
    private List<AmigaEncapsulator> encapsulators = new ArrayList<AmigaEncapsulator>();

    public void add(AmigaEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public AmigaSetEncapsulator(AmigaEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AmigaEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<AmigaEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AmigaSet asAmigaSet(Configuration context) {
        List<Amiga> result = new ArrayList<Amiga>();

        for (AmigaEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAmiga(context));
        }
        return new AmigaHashSet(result);
    }

    public boolean isValid() {
        for (AmigaEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateSetBuilder.toString();
    }
}

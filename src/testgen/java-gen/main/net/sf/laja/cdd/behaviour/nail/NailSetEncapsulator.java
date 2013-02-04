package net.sf.laja.cdd.behaviour.nail;

import java.util.*;
import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;

public class NailSetEncapsulator implements Iterable<NailEncapsulator> {
    public NailStateSetBuilder stateSetBuilder = new NailStateSetBuilder();
    private List<NailEncapsulator> encapsulators = new ArrayList<NailEncapsulator>();

    public void add(NailEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public NailSetEncapsulator(NailEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (NailEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<NailEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public NailSet asNailSet() {
        List<Nail> result = new ArrayList<Nail>();

        for (NailEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asNail());
        }
        return new NailHashSet(result);
    }

    public boolean isValid() {
        for (NailEncapsulator encapsulator : encapsulators) {
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

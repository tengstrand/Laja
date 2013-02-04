package net.sf.laja.cdd.behaviour.nail;

import java.util.*;
import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;

public class NailListEncapsulator implements Iterable<NailEncapsulator> {
    public NailStateListBuilder stateListBuilder = new NailStateListBuilder();
    private List<NailEncapsulator> encapsulators = new ArrayList<NailEncapsulator>();

    public void add(NailEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public NailListEncapsulator(NailEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (NailEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<NailEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public NailList asNailList() {
        List<Nail> result = new ArrayList<Nail>();

        for (NailEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asNail());
        }
        return new NailArrayList(result);
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
        return stateListBuilder.toString();
    }
}

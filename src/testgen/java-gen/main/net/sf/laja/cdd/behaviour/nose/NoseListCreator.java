package net.sf.laja.cdd.behaviour.nose;

import java.util.*;
import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseListCreator implements Iterable<NoseEncapsulator> {
    public NoseStateListBuilder stateList = new NoseStateListBuilder();
    private List<NoseEncapsulator> encapsulators = new ArrayList<NoseEncapsulator>();

    public void add(NoseEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public NoseListCreator(NoseEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (NoseEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<NoseEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public boolean isValid() {
        for (NoseEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

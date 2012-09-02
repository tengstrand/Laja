package net.sf.laja.cdd.behaviour.ear;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarListCreator implements Iterable<EarEncapsulator> {
    public EarStateListBuilder stateList = new EarStateListBuilder();
    private List<EarEncapsulator> encapsulators = new ArrayList<EarEncapsulator>();

    public void add(EarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public EarListCreator(EarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (EarEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<EarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public boolean isValid() {
        for (EarEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

package net.sf.laja.cdd.behaviour.ear;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TheEarListEncapsulator implements Iterable<TheEarEncapsulator> {
    public EarStateListBuilder stateListBuilder = new EarStateListBuilder();
    private List<TheEarEncapsulator> encapsulators = new ArrayList<TheEarEncapsulator>();

    public void add(TheEarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TheEarListEncapsulator(TheEarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TheEarEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TheEarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TheEarList asTheEarList() {
        List<TheEar> result = new ArrayList<TheEar>();

        for (TheEarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTheEar());
        }
        return new TheEarArrayList(result);
    }

    public boolean isValid() {
        for (TheEarEncapsulator encapsulator : encapsulators) {
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

package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.EarStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EarListEncapsulator implements Iterable<EarEncapsulator> {
    public EarStateListBuilder stateList = new EarStateListBuilder();
    private List<EarEncapsulator> encapsulators = new ArrayList<EarEncapsulator>();

    public void add(EarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public EarListEncapsulator(EarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (EarEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<EarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public EarList asEarList() {
        List<Ear> result = new ArrayList<Ear>();

        for (EarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asEar());
        }
        return new EarArrayList(result);
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

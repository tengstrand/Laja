package net.sf.laja.cdd.behaviour.fleck;

import java.util.*;
import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckListEncapsulator implements Iterable<FleckEncapsulator> {
    public FleckStateListBuilder stateList = new FleckStateListBuilder();
    private List<FleckEncapsulator> encapsulators = new ArrayList<FleckEncapsulator>();

    public void add(FleckEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public FleckListEncapsulator(FleckEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FleckEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<FleckEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FleckList asFleckList() {
        List<Fleck> result = new ArrayList<Fleck>();

        for (FleckEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFleck());
        }
        return new FleckArrayList(result);
    }

    public boolean isValid() {
        for (FleckEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

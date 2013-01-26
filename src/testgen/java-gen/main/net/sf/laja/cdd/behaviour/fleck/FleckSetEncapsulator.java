package net.sf.laja.cdd.behaviour.fleck;

import java.util.*;
import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckSetEncapsulator implements Iterable<FleckEncapsulator> {
    public FleckStateSetBuilder stateSetBuilder = new FleckStateSetBuilder();
    private List<FleckEncapsulator> encapsulators = new ArrayList<FleckEncapsulator>();

    public void add(FleckEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public FleckSetEncapsulator(FleckEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FleckEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FleckEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FleckSet asFleckSet() {
        List<Fleck> result = new ArrayList<Fleck>();

        for (FleckEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFleck());
        }
        return new FleckHashSet(result);
    }

    public boolean isValid() {
        for (FleckEncapsulator encapsulator : encapsulators) {
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

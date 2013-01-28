package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightSetEncapsulator implements Iterable<HeightEncapsulator> {
    public HeightStateSetBuilder stateSetBuilder = new HeightStateSetBuilder();
    private List<HeightEncapsulator> encapsulators = new ArrayList<HeightEncapsulator>();

    public void add(HeightEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public HeightSetEncapsulator(HeightEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HeightEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<HeightEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HeightSet asHeightSet() {
        List<Height> result = new ArrayList<Height>();

        for (HeightEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHeight());
        }
        return new HeightHashSet(result);
    }

    public boolean isValid() {
        for (HeightEncapsulator encapsulator : encapsulators) {
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

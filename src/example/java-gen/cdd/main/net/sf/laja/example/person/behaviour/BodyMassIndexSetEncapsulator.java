package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndexSetEncapsulator implements Iterable<BodyMassIndexEncapsulator> {
    public BmiStateSetBuilder stateSetBuilder = new BmiStateSetBuilder();
    private List<BodyMassIndexEncapsulator> encapsulators = new ArrayList<BodyMassIndexEncapsulator>();

    public void add(BodyMassIndexEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public BodyMassIndexSetEncapsulator(BodyMassIndexEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<BodyMassIndexEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BodyMassIndexSet asBodyMassIndexSet() {
        List<BodyMassIndex> result = new ArrayList<BodyMassIndex>();

        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBodyMassIndex());
        }
        return new BodyMassIndexHashSet(result);
    }

    public boolean isValid() {
        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
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

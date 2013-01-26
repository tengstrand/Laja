package net.sf.laja.cdd.behaviour.nose;

import java.util.*;
import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseSetEncapsulator implements Iterable<NoseEncapsulator> {
    public NoseStateSetBuilder stateSetBuilder = new NoseStateSetBuilder();
    private List<NoseEncapsulator> encapsulators = new ArrayList<NoseEncapsulator>();

    public void add(NoseEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public NoseSetEncapsulator(NoseEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (NoseEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<NoseEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public NoseSet asNoseSet(int extraParameter) {
        List<Nose> result = new ArrayList<Nose>();

        for (NoseEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asNose(extraParameter));
        }
        return new NoseHashSet(result);
    }

    public BigNoseSet asBigNoseSet() {
        List<BigNose> result = new ArrayList<BigNose>();

        for (NoseEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBigNose());
        }
        return new BigNoseHashSet(result);
    }

    public boolean isValid() {
        for (NoseEncapsulator encapsulator : encapsulators) {
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

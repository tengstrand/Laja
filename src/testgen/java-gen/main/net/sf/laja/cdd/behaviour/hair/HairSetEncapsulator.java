package net.sf.laja.cdd.behaviour.hair;

import java.util.*;
import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;

public class HairSetEncapsulator implements Iterable<HairEncapsulator> {
    public HairStateSetBuilder stateSetBuilder = new HairStateSetBuilder();
    private List<HairEncapsulator> encapsulators = new ArrayList<HairEncapsulator>();

    public void add(HairEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public HairSetEncapsulator(HairEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HairEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<HairEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HairSet asHairSet() {
        List<Hair> result = new ArrayList<Hair>();

        for (HairEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHair());
        }
        return new HairHashSet(result);
    }

    public FakeHairSet asFakeHairSet() {
        List<FakeHair> result = new ArrayList<FakeHair>();

        for (HairEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFakeHair());
        }
        return new FakeHairHashSet(result);
    }

    public boolean isValid() {
        for (HairEncapsulator encapsulator : encapsulators) {
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

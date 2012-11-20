package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HairListEncapsulator implements Iterable<HairEncapsulator> {
    public HairStateListBuilder stateList = new HairStateListBuilder();
    private List<HairEncapsulator> encapsulators = new ArrayList<HairEncapsulator>();

    public void add(HairEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HairListEncapsulator(HairEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HairEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<HairEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HairList asHairList() {
        List<Hair> result = new ArrayList<Hair>();

        for (HairEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHair());
        }
        return new HairArrayList(result);
    }

    public FakeHairList asFakeHairList() {
        List<FakeHair> result = new ArrayList<FakeHair>();

        for (HairEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFakeHair());
        }
        return new FakeHairArrayList(result);
    }

    public boolean isValid() {
        for (HairEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

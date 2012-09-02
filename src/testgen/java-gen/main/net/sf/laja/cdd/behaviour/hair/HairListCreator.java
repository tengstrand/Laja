package net.sf.laja.cdd.behaviour.hair;

import java.util.*;
import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;

public class HairListCreator implements Iterable<HairEncapsulator> {
    public HairStateListBuilder stateList = new HairStateListBuilder();
    private List<HairEncapsulator> encapsulators = new ArrayList<HairEncapsulator>();

    public void add(HairEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HairListCreator(HairEncapsulator... encapsulators) {
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
        return new HairList(result);
    }

    public FakeHairList asFakeHairList() {
        List<FakeHair> result = new ArrayList<FakeHair>();

        for (HairEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFakeHair());
        }
        return new FakeHairList(result);
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

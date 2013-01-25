package net.sf.laja.cdd.behaviour.nose;

import java.util.*;
import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseListEncapsulator implements Iterable<NoseEncapsulator> {
    public NoseStateListBuilder stateListBuilder = new NoseStateListBuilder();
    private List<NoseEncapsulator> encapsulators = new ArrayList<NoseEncapsulator>();

    public void add(NoseEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public NoseListEncapsulator(NoseEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (NoseEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<NoseEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public NoseList asNoseList(int extraParameter) {
        List<Nose> result = new ArrayList<Nose>();

        for (NoseEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asNose(extraParameter));
        }
        return new NoseArrayList(result);
    }

    public BigNoseList asBigNoseList() {
        List<BigNose> result = new ArrayList<BigNose>();

        for (NoseEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBigNose());
        }
        return new BigNoseArrayList(result);
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
        return stateListBuilder.toString();
    }
}

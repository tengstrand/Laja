package net.sf.laja.cdd.behaviour.mouth;

import java.util.*;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthSetEncapsulator implements Iterable<MouthEncapsulator> {
    public MouthStateSetBuilder stateSetBuilder = new MouthStateSetBuilder();
    private List<MouthEncapsulator> encapsulators = new ArrayList<MouthEncapsulator>();

    public void add(MouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public MouthSetEncapsulator(MouthEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MouthEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<MouthEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public MouthSet asMouthSet(MouthSize size) {
        List<Mouth> result = new ArrayList<Mouth>();

        for (MouthEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asMouth(size));
        }
        return new MouthHashSet(result);
    }

    public boolean isValid() {
        for (MouthEncapsulator encapsulator : encapsulators) {
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

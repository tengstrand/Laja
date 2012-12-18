package net.sf.laja.cdd.behaviour.mouth;

import java.util.*;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthListEncapsulator implements Iterable<MouthEncapsulator> {
    public MouthStateListBuilder stateListBuilder = new MouthStateListBuilder();
    private List<MouthEncapsulator> encapsulators = new ArrayList<MouthEncapsulator>();

    public void add(MouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public MouthListEncapsulator(MouthEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MouthEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<MouthEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public MouthList asMouthList(MouthSize size) {
        List<Mouth> result = new ArrayList<Mouth>();

        for (MouthEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asMouth(size));
        }
        return new MouthArrayList(result);
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
        return stateListBuilder.toString();
    }
}

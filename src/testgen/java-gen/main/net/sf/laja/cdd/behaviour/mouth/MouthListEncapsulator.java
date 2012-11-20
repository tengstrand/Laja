package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MouthListEncapsulator implements Iterable<MouthEncapsulator> {
    public MouthStateListBuilder stateList = new MouthStateListBuilder();
    private List<MouthEncapsulator> encapsulators = new ArrayList<MouthEncapsulator>();

    public void add(MouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public MouthListEncapsulator(MouthEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MouthEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
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
}

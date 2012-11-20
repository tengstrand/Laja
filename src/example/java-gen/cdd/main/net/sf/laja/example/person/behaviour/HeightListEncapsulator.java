package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightListEncapsulator implements Iterable<HeightEncapsulator> {
    public HeightStateListBuilder stateList = new HeightStateListBuilder();
    private List<HeightEncapsulator> encapsulators = new ArrayList<HeightEncapsulator>();

    public void add(HeightEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HeightListEncapsulator(HeightEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HeightEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<HeightEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HeightList asHeightList() {
        List<Height> result = new ArrayList<Height>();

        for (HeightEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHeight());
        }
        return new HeightArrayList(result);
    }

    public boolean isValid() {
        for (HeightEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndexListEncapsulator implements Iterable<BodyMassIndexEncapsulator> {
    public BmiStateListBuilder stateList = new BmiStateListBuilder();
    private List<BodyMassIndexEncapsulator> encapsulators = new ArrayList<BodyMassIndexEncapsulator>();

    public void add(BodyMassIndexEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public BodyMassIndexListEncapsulator(BodyMassIndexEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<BodyMassIndexEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BodyMassIndexList asBodyMassIndexList() {
        List<BodyMassIndex> result = new ArrayList<BodyMassIndex>();

        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBodyMassIndex());
        }
        return new BodyMassIndexArrayList(result);
    }

    public boolean isValid() {
        for (BodyMassIndexEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

package net.sf.laja.cdd.behaviour.eye;

import java.util.*;
import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;

public class EyeListEncapsulator implements Iterable<EyeEncapsulator> {
    public EyeStateListBuilder stateListBuilder = new EyeStateListBuilder();
    private List<EyeEncapsulator> encapsulators = new ArrayList<EyeEncapsulator>();

    public void add(EyeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public EyeListEncapsulator(EyeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (EyeEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<EyeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public EyeList asEyeList() {
        List<Eye> result = new ArrayList<Eye>();

        for (EyeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asEye());
        }
        return new EyeArrayList(result);
    }

    public boolean isValid() {
        for (EyeEncapsulator encapsulator : encapsulators) {
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

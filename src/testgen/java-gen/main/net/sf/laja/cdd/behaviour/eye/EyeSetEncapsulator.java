package net.sf.laja.cdd.behaviour.eye;

import java.util.*;
import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;

public class EyeSetEncapsulator implements Iterable<EyeEncapsulator> {
    public EyeStateSetBuilder stateSetBuilder = new EyeStateSetBuilder();
    private List<EyeEncapsulator> encapsulators = new ArrayList<EyeEncapsulator>();

    public void add(EyeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public EyeSetEncapsulator(EyeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (EyeEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<EyeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public EyeSet asEyeSet() {
        List<Eye> result = new ArrayList<Eye>();

        for (EyeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asEye());
        }
        return new EyeHashSet(result);
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
        return stateSetBuilder.toString();
    }
}

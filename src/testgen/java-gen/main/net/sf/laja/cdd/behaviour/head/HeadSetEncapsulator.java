package net.sf.laja.cdd.behaviour.head;

import java.util.*;
import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthArrayList;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;

public class HeadSetEncapsulator implements Iterable<HeadEncapsulator> {
    public HeadStateSetBuilder stateSetBuilder = new HeadStateSetBuilder();
    private List<HeadEncapsulator> encapsulators = new ArrayList<HeadEncapsulator>();

    public void add(HeadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public HeadSetEncapsulator(HeadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HeadEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<HeadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HeadSet asHeadSet() {
        List<Head> result = new ArrayList<Head>();

        for (HeadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHead());
        }
        return new HeadHashSet(result);
    }

    public boolean isValid() {
        for (HeadEncapsulator encapsulator : encapsulators) {
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

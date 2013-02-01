package net.sf.laja.cdd.behaviour.arm;

import java.util.*;
import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandHashSet;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.hand.HandSet;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.hand.HandStateList;

public class ArmSetEncapsulator implements Iterable<ArmEncapsulator> {
    public ArmStateSetBuilder stateSetBuilder = new ArmStateSetBuilder();
    private List<ArmEncapsulator> encapsulators = new ArrayList<ArmEncapsulator>();

    public void add(ArmEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public ArmSetEncapsulator(ArmEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ArmEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ArmEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ArmSet asArmSet() {
        List<Arm> result = new ArrayList<Arm>();

        for (ArmEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asArm());
        }
        return new ArmHashSet(result);
    }

    public boolean isValid() {
        for (ArmEncapsulator encapsulator : encapsulators) {
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

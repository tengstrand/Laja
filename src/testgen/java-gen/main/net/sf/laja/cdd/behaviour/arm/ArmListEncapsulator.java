package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.ArmStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArmListEncapsulator implements Iterable<ArmEncapsulator> {
    public ArmStateListBuilder stateList = new ArmStateListBuilder();
    private List<ArmEncapsulator> encapsulators = new ArrayList<ArmEncapsulator>();

    public void add(ArmEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public ArmListEncapsulator(ArmEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ArmEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<ArmEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ArmList asArmList() {
        List<Arm> result = new ArrayList<Arm>();

        for (ArmEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asArm());
        }
        return new ArmArrayList(result);
    }

    public boolean isValid() {
        for (ArmEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

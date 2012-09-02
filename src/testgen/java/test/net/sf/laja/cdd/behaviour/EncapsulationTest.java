package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.arm.Arm;
import net.sf.laja.cdd.behaviour.arm.ArmBuilder;
import net.sf.laja.cdd.behaviour.arm.ArmEncapsulator;
import org.junit.Test;

public class EncapsulationTest {

    @Test (expected = IllegalStateException.class)
    public void modifyEncapsulatedObject_viaTheEncapsulator() {
        ArmEncapsulator encapsulator = Arm.armWeight(10);
        encapsulator.asArm();

        // Trying to modify state after encapsulation.
        encapsulator.withArmLength(20);
    }

    @Test (expected = IllegalStateException.class)
    public void modifyEncapsulatedObject_viaTheBuilder() {
        ArmBuilder builder = Arm.build();
        builder.asArm();

        // Trying to modify state after encapsulation.
        builder.withArmLength(10);
    }

    @Test (expected = IllegalStateException.class)
    public void modifyEncapsulatedList() {
        ArmEncapsulator encapsulator = Arm.armWeight(1);
        Arm.createList(encapsulator).asArmList();

        // Trying to modify state of an element after encapsulation of the list.
        encapsulator.withArmLength(3);
    }
}

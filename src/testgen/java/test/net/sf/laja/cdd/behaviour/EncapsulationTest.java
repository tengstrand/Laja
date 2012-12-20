package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.arm.Arm;
import net.sf.laja.cdd.behaviour.arm.ArmBuilder;
import net.sf.laja.cdd.behaviour.arm.ArmEncapsulator;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.forehead.Forehead;
import net.sf.laja.cdd.behaviour.forehead.ForeheadWithBigBrows;
import net.sf.laja.cdd.behaviour.hair.Hair;
import net.sf.laja.cdd.behaviour.hair.HairList;
import org.junit.Test;

import java.util.Collections;

public class EncapsulationTest {

    @Test (expected = IllegalStateException.class)
    public void modifyEncapsulatedObject_viaTheEncapsulator() {
        ArmEncapsulator encapsulator = Arm.armWeight(10).hands();
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
        ArmEncapsulator encapsulator = Arm.armWeight(1).hands();
        Arm.createList(encapsulator).asArmList();

        // Trying to modify state of an element after encapsulation of the list.
        encapsulator.withArmLength(3);
    }

    @Test
    public void shouldBePossibleToMutateStateInCurrentContext() {
        Hair hair = Hair.length(10).color("red").asHair();

        hair.mutate();
    }

    @Test (expected = IllegalStateException.class)
    public void shouldNotBePossibleToMutateStateFromAnotherContext() {
        Hair hair = Hair.length(10).color("red").asHair();

        // Switch context to 'fake hair'
        hair.asFakeHair();

        // Mutate state from the old context
        hair.mutate();
    }

    @Test
    public void shouldBePossibleToMutateStateListFromCurrentContext() {
        Forehead forehead = Forehead.create().withBrows(Brow.area(1)).asForehead();

        // Switch context.
        ForeheadWithBigBrows foreheadWithBigBrows = forehead.asForeheadWithBigBrows();

        // Mutate state from current context.
        foreheadWithBigBrows.mutate();
    }

    @Test (expected = IllegalStateException.class)
    public void shouldNotBePossibleToMutateStateListFromAnotherContext() {
        Forehead forehead = Forehead.create().withBrows(Brow.area(1)).asForehead();

        // Switch context.
        forehead.asForeheadWithBigBrows();

        // Mutate state from the old context.
        forehead.mutate();
    }
}

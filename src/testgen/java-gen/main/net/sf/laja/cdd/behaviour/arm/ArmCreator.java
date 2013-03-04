package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandHashSet;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.hand.HandSet;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.hand.HandStateList;
import net.sf.laja.cdd.behaviour.hand.HandEncapsulator;
import net.sf.laja.cdd.behaviour.hand.HandListEncapsulator;

public class ArmCreator {
    private final ArmStateBuilder builder = ArmStateImpl.build();

    public class ArmWeight_ {
        public Hands_ armWeight(double armWeight) {
            builder.withArmWeight(armWeight);
            return new Hands_();
        }
    }

    public class Hands_ {
        public ArmEncapsulator hands(HandEncapsulator... hands) {
            HandListEncapsulator encapsulator = new HandListEncapsulator(hands);
            builder.withHands(encapsulator.stateListBuilder);
            return create();
        }
    }

    public ArmEncapsulator create() {
        return new ArmEncapsulator(builder);
     }
}

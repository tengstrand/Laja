package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.ArmStateList;

import java.util.List;

public class ArmList extends ArmAbstractList {
    public ArmList(Arm... list) {
        super(list);
    }

    public ArmList(List<Arm> list) {
        super(list);
    }

    public ArmList(ArmStateList stateList) {
        super(stateList);
    }
}

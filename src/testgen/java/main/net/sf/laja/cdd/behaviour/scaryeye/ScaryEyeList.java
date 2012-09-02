package net.sf.laja.cdd.behaviour.scaryeye;

import net.sf.laja.cdd.state.eye.EyeStateListBuilder;

import java.util.List;

public class ScaryEyeList extends ScaryEyeAbstractList {
    public ScaryEyeList(ScaryEye... list) {
        super(list);
    }

    public ScaryEyeList(List<ScaryEye> list) {
        super(list);
    }

    public ScaryEyeList(List<ScaryEye> list, EyeStateListBuilder stateListBuilder) {
        super(list, stateListBuilder);
    }
}

package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairStateListBuilder;

import java.util.List;

public class FakeHairList extends FakeHairAbstractList {
    public FakeHairList(FakeHair... list) {
        super(list);
    }

    public FakeHairList(List<FakeHair> list) {
        super(list);
    }

    public FakeHairList(List<FakeHair> list, HairStateListBuilder stateListBuilder) {
        super(list, stateListBuilder);
    }
}

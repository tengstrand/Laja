package net.sf.laja.cdd.behaviour.hair;

import java.util.List;

public class FakeHairList extends FakeHairArrayList {
    public FakeHairList(FakeHair... list) {
        super(list);
    }

    public FakeHairList(List<FakeHair> list) {
        super(list);
    }
}

package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;

public class CuteMouthList extends CuteMouthAbstractList {
    public CuteMouthList(CuteMouth... list) {
        super(list);
    }

    public CuteMouthList(List<CuteMouth> list) {
        super(list);
    }

    public CuteMouthList(List<CuteMouth> list, MouthStateListBuilder stateListBuilder) {
        super(list, stateListBuilder);
    }

    public void doSomething() {
        int x = 1;
    }
}

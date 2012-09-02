package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;
import net.sf.laja.cdd.state.mouth.MouthStateList;

public class MouthList extends MouthAbstractList {
    public MouthList(Mouth... list) {
        super(list);
    }

    public MouthList(List<Mouth> list) {
        super(list);
    }

    public MouthList(MouthStateList stateList, MouthSize size) {
        super(stateList, size);
    }
}

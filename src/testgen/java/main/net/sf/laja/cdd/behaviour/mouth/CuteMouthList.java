package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;

public class CuteMouthList extends CuteMouthArrayList {
    public CuteMouthList(CuteMouth... list) {
        super(list);
    }

    public CuteMouthList(List<CuteMouth> list) {
        super(list);
    }

    public void doSomething() {
        int x = 1;
    }
}

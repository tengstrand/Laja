package net.sf.laja.cdd.behaviour;

import java.util.List;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthList;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthArrayList;

public interface TestMouthList extends List<TestMouth> {
    CuteMouthList asCuteMouthList();
}

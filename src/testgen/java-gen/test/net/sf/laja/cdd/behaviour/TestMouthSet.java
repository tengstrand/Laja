package net.sf.laja.cdd.behaviour;

import java.util.Set;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthSet;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthHashSet;

public interface TestMouthSet extends Set<TestMouth> {
    CuteMouthSet asCuteMouthSet();
}

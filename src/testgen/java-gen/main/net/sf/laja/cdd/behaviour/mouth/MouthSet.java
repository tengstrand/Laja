package net.sf.laja.cdd.behaviour.mouth;

import java.util.Set;

public interface MouthSet extends Set<Mouth> {
    CuteMouthSet asCuteMouthSet(MouthSize size, int x);
}

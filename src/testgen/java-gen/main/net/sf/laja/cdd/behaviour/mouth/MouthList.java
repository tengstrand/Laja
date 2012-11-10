package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;

public interface MouthList extends List<Mouth> {
    CuteMouthList asCuteMouthList(MouthSize size, int x);
}

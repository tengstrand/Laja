package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;

public interface MouthList extends List<Mouth> {
    CuteMouthArrayList asCuteMouthList(MouthSize size, int x);
}

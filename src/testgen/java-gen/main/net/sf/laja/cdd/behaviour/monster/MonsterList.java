package net.sf.laja.cdd.behaviour.monster;

import java.util.List;

import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.terrestrial.TerrestrialList;
import net.sf.laja.cdd.behaviour.terrestrial.TerrestrialArrayList;

public interface MonsterList extends List<Monster> {
    TerrestrialList asTerrestrialList();
}

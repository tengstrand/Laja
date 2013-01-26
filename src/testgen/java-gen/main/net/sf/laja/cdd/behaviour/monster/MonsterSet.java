package net.sf.laja.cdd.behaviour.monster;

import java.util.Set;

import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.terrestrial.TerrestrialSet;
import net.sf.laja.cdd.behaviour.terrestrial.TerrestrialHashSet;

public interface MonsterSet extends Set<Monster> {
    TerrestrialSet asTerrestrialSet();
}

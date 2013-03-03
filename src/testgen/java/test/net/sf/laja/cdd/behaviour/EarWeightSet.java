package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.ear.TheEar;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EarWeightSet extends EarHashSet {

    public EarWeightSet(Collection<TheEar> collection) {
        super(collection);
    }

    public List<Integer> weights() {
        List<Integer> result = new ArrayList<Integer>();
        for (TheEar ear : this) {
            result.add(ear.getWeight());
        }
        return result;
    }
}

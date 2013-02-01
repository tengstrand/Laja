package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.ear.Ear;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EarWeightSet extends EarHashSet {

    public EarWeightSet(Collection<Ear> collection) {
        super(collection);
    }

    public List<Integer> weights() {
        List<Integer> result = new ArrayList<Integer>();
        for (Ear ear : this) {
            result.add(ear.getWeight());
        }
        return result;
    }
}

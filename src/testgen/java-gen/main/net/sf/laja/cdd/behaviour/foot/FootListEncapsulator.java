package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.FootStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FootListEncapsulator implements Iterable<FootEncapsulator> {
    public FootStateListBuilder stateList = new FootStateListBuilder();
    private List<FootEncapsulator> encapsulators = new ArrayList<FootEncapsulator>();

    public void add(FootEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public FootListEncapsulator(FootEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FootEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<FootEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FootList asFootList() {
        List<Foot> result = new ArrayList<Foot>();

        for (FootEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFoot());
        }
        return new FootArrayList(result);
    }

    public boolean isValid() {
        for (FootEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

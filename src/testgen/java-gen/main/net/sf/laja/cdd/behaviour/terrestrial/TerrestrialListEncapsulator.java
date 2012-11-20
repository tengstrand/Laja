package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.TerrestrialStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TerrestrialListEncapsulator implements Iterable<TerrestrialEncapsulator> {
    public TerrestrialStateListBuilder stateList = new TerrestrialStateListBuilder();
    private List<TerrestrialEncapsulator> encapsulators = new ArrayList<TerrestrialEncapsulator>();

    public void add(TerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TerrestrialListEncapsulator(TerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<TerrestrialEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TerrestrialList asTerrestrialList() {
        List<Terrestrial> result = new ArrayList<Terrestrial>();

        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTerrestrial());
        }
        return new TerrestrialArrayList(result);
    }

    public boolean isValid() {
        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

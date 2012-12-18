package net.sf.laja.cdd.behaviour.terrestrial;

import java.util.*;
import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;

public class TerrestrialListEncapsulator implements Iterable<TerrestrialEncapsulator> {
    public TerrestrialStateListBuilder stateListBuilder = new TerrestrialStateListBuilder();
    private List<TerrestrialEncapsulator> encapsulators = new ArrayList<TerrestrialEncapsulator>();

    public void add(TerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TerrestrialListEncapsulator(TerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
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

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}

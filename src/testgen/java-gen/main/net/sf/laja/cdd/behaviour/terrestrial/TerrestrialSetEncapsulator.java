package net.sf.laja.cdd.behaviour.terrestrial;

import java.util.*;
import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;

public class TerrestrialSetEncapsulator implements Iterable<TerrestrialEncapsulator> {
    public TerrestrialStateSetBuilder stateSetBuilder = new TerrestrialStateSetBuilder();
    private List<TerrestrialEncapsulator> encapsulators = new ArrayList<TerrestrialEncapsulator>();

    public void add(TerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TerrestrialSetEncapsulator(TerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TerrestrialEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TerrestrialSet asTerrestrialSet() {
        List<Terrestrial> result = new ArrayList<Terrestrial>();

        for (TerrestrialEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTerrestrial());
        }
        return new TerrestrialHashSet(result);
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
        return stateSetBuilder.toString();
    }
}

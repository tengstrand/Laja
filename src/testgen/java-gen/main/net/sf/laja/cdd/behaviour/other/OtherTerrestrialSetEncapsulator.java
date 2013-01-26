package net.sf.laja.cdd.behaviour.other;

import java.util.*;
import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;

public class OtherTerrestrialSetEncapsulator implements Iterable<OtherTerrestrialEncapsulator> {
    public TerrestrialStateSetBuilder stateSetBuilder = new TerrestrialStateSetBuilder();
    private List<OtherTerrestrialEncapsulator> encapsulators = new ArrayList<OtherTerrestrialEncapsulator>();

    public void add(OtherTerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public OtherTerrestrialSetEncapsulator(OtherTerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<OtherTerrestrialEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public OtherTerrestrialSet asOtherTerrestrialSet() {
        List<OtherTerrestrial> result = new ArrayList<OtherTerrestrial>();

        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asOtherTerrestrial());
        }
        return new OtherTerrestrialHashSet(result);
    }

    public boolean isValid() {
        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
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

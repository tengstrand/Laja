package net.sf.laja.cdd.behaviour.other;

import java.util.*;
import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;

public class OtherTerrestrialListEncapsulator implements Iterable<OtherTerrestrialEncapsulator> {
    public TerrestrialStateListBuilder stateListBuilder = new TerrestrialStateListBuilder();
    private List<OtherTerrestrialEncapsulator> encapsulators = new ArrayList<OtherTerrestrialEncapsulator>();

    public void add(OtherTerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public OtherTerrestrialListEncapsulator(OtherTerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<OtherTerrestrialEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public OtherTerrestrialList asOtherTerrestrialList() {
        List<OtherTerrestrial> result = new ArrayList<OtherTerrestrial>();

        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asOtherTerrestrial());
        }
        return new OtherTerrestrialArrayList(result);
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
        return stateListBuilder.toString();
    }
}

package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.TerrestrialStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OtherTerrestrialListEncapsulator implements Iterable<OtherTerrestrialEncapsulator> {
    public TerrestrialStateListBuilder stateList = new TerrestrialStateListBuilder();
    private List<OtherTerrestrialEncapsulator> encapsulators = new ArrayList<OtherTerrestrialEncapsulator>();

    public void add(OtherTerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public OtherTerrestrialListEncapsulator(OtherTerrestrialEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (OtherTerrestrialEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
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
}

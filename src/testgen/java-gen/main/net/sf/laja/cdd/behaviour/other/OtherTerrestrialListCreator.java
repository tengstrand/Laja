package net.sf.laja.cdd.behaviour.other;

import java.util.*;
import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;

public class OtherTerrestrialListCreator implements Iterable<OtherTerrestrialEncapsulator> {
    public TerrestrialStateListBuilder stateList = new TerrestrialStateListBuilder();
    private List<OtherTerrestrialEncapsulator> encapsulators = new ArrayList<OtherTerrestrialEncapsulator>();

    public void add(OtherTerrestrialEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public OtherTerrestrialListCreator(OtherTerrestrialEncapsulator... encapsulators) {
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
        return new OtherTerrestrialList(result);
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

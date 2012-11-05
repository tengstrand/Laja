package net.sf.laja.cdd.behaviour.head;

import java.util.*;
import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthArrayList;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;

public class HeadListCreator implements Iterable<HeadEncapsulator> {
    public HeadStateListBuilder stateList = new HeadStateListBuilder();
    private List<HeadEncapsulator> encapsulators = new ArrayList<HeadEncapsulator>();

    public void add(HeadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HeadListCreator(HeadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HeadEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<HeadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HeadList asHeadList() {
        List<Head> result = new ArrayList<Head>();

        for (HeadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHead());
        }
        return new HeadArrayList(result);
    }

    public boolean isValid() {
        for (HeadEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

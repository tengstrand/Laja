package net.sf.laja.cdd.behaviour.toe;

import java.util.*;
import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeListEncapsulator implements Iterable<ToeEncapsulator> {
    public ToeStateListBuilder stateList = new ToeStateListBuilder();
    private List<ToeEncapsulator> encapsulators = new ArrayList<ToeEncapsulator>();

    public void add(ToeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public ToeListEncapsulator(ToeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ToeEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<ToeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ToeList asToeList() {
        List<Toe> result = new ArrayList<Toe>();

        for (ToeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asToe());
        }
        return new ToeArrayList(result);
    }

    public ValToeList asValToeList() {
        List<ValToe> result = new ArrayList<ValToe>();

        for (ToeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asValToe());
        }
        return new ValToeArrayList(result);
    }

    public boolean isValid() {
        for (ToeEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

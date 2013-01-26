package net.sf.laja.example.computer.behaviour;

import java.util.*;
import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariSetEncapsulator implements Iterable<AtariEncapsulator> {
    public ComputerStateSetBuilder stateSetBuilder = new ComputerStateSetBuilder();
    private List<AtariEncapsulator> encapsulators = new ArrayList<AtariEncapsulator>();

    public void add(AtariEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public AtariSetEncapsulator(AtariEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AtariEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<AtariEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AtariSTSet asAtariSTSet() {
        List<AtariST> result = new ArrayList<AtariST>();

        for (AtariEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAtariST());
        }
        return new AtariSTHashSet(result);
    }

    public AtariFalcon030Set asAtariFalcon030Set() {
        List<AtariFalcon030> result = new ArrayList<AtariFalcon030>();

        for (AtariEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAtariFalcon030());
        }
        return new AtariFalcon030HashSet(result);
    }

    public boolean isValid() {
        for (AtariEncapsulator encapsulator : encapsulators) {
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

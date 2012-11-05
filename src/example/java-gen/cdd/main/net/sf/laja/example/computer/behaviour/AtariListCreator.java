package net.sf.laja.example.computer.behaviour;

import java.util.*;
import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariListCreator implements Iterable<AtariEncapsulator> {
    public ComputerStateListBuilder stateList = new ComputerStateListBuilder();
    private List<AtariEncapsulator> encapsulators = new ArrayList<AtariEncapsulator>();

    public void add(AtariEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public AtariListCreator(AtariEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AtariEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<AtariEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AtariSTList asAtariSTList() {
        List<AtariST> result = new ArrayList<AtariST>();

        for (AtariEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAtariST());
        }
        return new AtariSTArrayList(result);
    }

    public AtariFalcon030List asAtariFalcon030List() {
        List<AtariFalcon030> result = new ArrayList<AtariFalcon030>();

        for (AtariEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAtariFalcon030());
        }
        return new AtariFalcon030ArrayList(result);
    }

    public boolean isValid() {
        for (AtariEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

package net.sf.laja.example.computer.behaviour;

import java.util.*;
import net.sf.laja.example.computer.state.*;
import net.sf.laja.example.computer.state.*;

public class AmigaListEncapsulator implements Iterable<AmigaEncapsulator> {
    public ComputerStateListBuilder stateList = new ComputerStateListBuilder();
    private List<AmigaEncapsulator> encapsulators = new ArrayList<AmigaEncapsulator>();

    public void add(AmigaEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public AmigaListEncapsulator(AmigaEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AmigaEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<AmigaEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AmigaList asAmigaList(Configuration context) {
        List<Amiga> result = new ArrayList<Amiga>();

        for (AmigaEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAmiga(context));
        }
        return new AmigaArrayList(result);
    }

    public boolean isValid() {
        for (AmigaEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

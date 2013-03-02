package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;

public class ZipcodeListEncapsulator implements Iterable<ZipcodeEncapsulator> {
    public ZipcodeStateListBuilder stateListBuilder = new ZipcodeStateListBuilder();
    private List<ZipcodeEncapsulator> encapsulators = new ArrayList<ZipcodeEncapsulator>();

    public void add(ZipcodeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public ZipcodeListEncapsulator(ZipcodeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ZipcodeEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ZipcodeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ZipcodeList asZipcodeList() {
        List<Zipcode> result = new ArrayList<Zipcode>();

        for (ZipcodeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asZipcode());
        }
        return new ZipcodeArrayList(result);
    }

    public boolean isValid() {
        for (ZipcodeEncapsulator encapsulator : encapsulators) {
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

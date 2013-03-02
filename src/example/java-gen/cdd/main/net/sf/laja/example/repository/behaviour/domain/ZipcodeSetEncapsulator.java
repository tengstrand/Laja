package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;

public class ZipcodeSetEncapsulator implements Iterable<ZipcodeEncapsulator> {
    public ZipcodeStateSetBuilder stateSetBuilder = new ZipcodeStateSetBuilder();
    private List<ZipcodeEncapsulator> encapsulators = new ArrayList<ZipcodeEncapsulator>();

    public void add(ZipcodeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public ZipcodeSetEncapsulator(ZipcodeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ZipcodeEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ZipcodeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ZipcodeSet asZipcodeSet() {
        List<Zipcode> result = new ArrayList<Zipcode>();

        for (ZipcodeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asZipcode());
        }
        return new ZipcodeHashSet(result);
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
        return stateSetBuilder.toString();
    }
}

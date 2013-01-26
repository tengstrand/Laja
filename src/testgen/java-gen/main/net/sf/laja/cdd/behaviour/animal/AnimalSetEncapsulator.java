package net.sf.laja.cdd.behaviour.animal;

import java.util.*;
import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalSetEncapsulator implements Iterable<AnimalEncapsulator> {
    public AnimalStateSetBuilder stateSetBuilder = new AnimalStateSetBuilder();
    private List<AnimalEncapsulator> encapsulators = new ArrayList<AnimalEncapsulator>();

    public void add(AnimalEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public AnimalSetEncapsulator(AnimalEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AnimalEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<AnimalEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AnimalSet asAnimalSet() {
        List<Animal> result = new ArrayList<Animal>();

        for (AnimalEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAnimal());
        }
        return new AnimalHashSet(result);
    }

    public boolean isValid() {
        for (AnimalEncapsulator encapsulator : encapsulators) {
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

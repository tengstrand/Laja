package net.sf.laja.cdd.behaviour.animal;

import java.util.*;
import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalListEncapsulator implements Iterable<AnimalEncapsulator> {
    public AnimalStateListBuilder stateList = new AnimalStateListBuilder();
    private List<AnimalEncapsulator> encapsulators = new ArrayList<AnimalEncapsulator>();

    public void add(AnimalEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public AnimalListEncapsulator(AnimalEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AnimalEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<AnimalEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AnimalList asAnimalList() {
        List<Animal> result = new ArrayList<Animal>();

        for (AnimalEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAnimal());
        }
        return new AnimalArrayList(result);
    }

    public boolean isValid() {
        for (AnimalEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

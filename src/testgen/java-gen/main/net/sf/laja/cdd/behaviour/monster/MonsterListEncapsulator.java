package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.MonsterStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MonsterListEncapsulator implements Iterable<MonsterEncapsulator> {
    public MonsterStateListBuilder stateList = new MonsterStateListBuilder();
    private List<MonsterEncapsulator> encapsulators = new ArrayList<MonsterEncapsulator>();

    public void add(MonsterEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public MonsterListEncapsulator(MonsterEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MonsterEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<MonsterEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public MonsterList asMonsterList() {
        List<Monster> result = new ArrayList<Monster>();

        for (MonsterEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asMonster());
        }
        return new MonsterArrayList(result);
    }

    public boolean isValid() {
        for (MonsterEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}

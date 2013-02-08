package net.sf.laja.cdd.behaviour.monster;

import java.util.*;
import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;

public class MonsterListEncapsulator implements Iterable<MonsterEncapsulator> {
    public MonsterStateListBuilder stateListBuilder = new MonsterStateListBuilder();
    private List<MonsterEncapsulator> encapsulators = new ArrayList<MonsterEncapsulator>();

    public void add(MonsterEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public MonsterListEncapsulator(MonsterEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MonsterEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
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

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}

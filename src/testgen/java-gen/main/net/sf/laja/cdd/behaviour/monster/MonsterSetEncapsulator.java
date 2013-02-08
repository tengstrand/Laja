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

public class MonsterSetEncapsulator implements Iterable<MonsterEncapsulator> {
    public MonsterStateSetBuilder stateSetBuilder = new MonsterStateSetBuilder();
    private List<MonsterEncapsulator> encapsulators = new ArrayList<MonsterEncapsulator>();

    public void add(MonsterEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public MonsterSetEncapsulator(MonsterEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (MonsterEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<MonsterEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public MonsterSet asMonsterSet() {
        List<Monster> result = new ArrayList<Monster>();

        for (MonsterEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asMonster());
        }
        return new MonsterHashSet(result);
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
        return stateSetBuilder.toString();
    }
}

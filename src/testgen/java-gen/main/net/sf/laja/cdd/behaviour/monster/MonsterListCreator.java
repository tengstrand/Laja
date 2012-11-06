package net.sf.laja.cdd.behaviour.monster;

import java.util.*;
import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import java.math.BigDecimal;

public class MonsterListCreator implements Iterable<MonsterEncapsulator> {
    public MonsterStateListBuilder stateList = new MonsterStateListBuilder();
    private List<MonsterEncapsulator> encapsulators = new ArrayList<MonsterEncapsulator>();

    public void add(MonsterEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public MonsterListCreator(MonsterEncapsulator... encapsulators) {
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
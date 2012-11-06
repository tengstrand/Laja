package net.sf.laja.cdd.behaviour.monster;

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
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseListCreator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;
import net.sf.laja.cdd.behaviour.ear.EarListCreator;
import net.sf.laja.cdd.behaviour.mouth.MouthListCreator;

public class MonsterEncapsulator {
    public final MonsterStateBuilder builder;

    public MonsterEncapsulator(MonsterStateBuilder builder) {
        this.builder = builder;
    }

    public Monster asMonster() {
        return (Monster)builder.as(new MonsterFactory.MonsterFactory_(builder));
    }

    public MonsterEncapsulator withMidEye(EyeEncapsulator midEye) {
        builder.withMidEye(midEye.builder);
        return this;
    }

    public MonsterEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListCreator creator = new BrowListCreator(brows);
        builder.withBrows(creator.stateList);
        return this;
    }

    public MonsterEncapsulator withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public MonsterEncapsulator withEars(EarEncapsulator... ears) {
        EarListCreator creator = new EarListCreator(ears);
        builder.withEars(creator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}

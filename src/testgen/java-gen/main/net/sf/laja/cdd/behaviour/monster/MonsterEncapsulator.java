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
import java.math.BigDecimal;
import net.sf.laja.cdd.state.eye.EyeState;
// Toe
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarSetEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseListEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarListEncapsulator;
import net.sf.laja.cdd.behaviour.mouth.MouthListEncapsulator;

public class MonsterEncapsulator implements MonsterStateComparable {
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
        BrowListEncapsulator encapsulator = new BrowListEncapsulator(brows);
        builder.withBrows(encapsulator.stateListBuilder);
        return this;
    }

    public MonsterEncapsulator withEars(EarEncapsulator... ears) {
        EarSetEncapsulator encapsulator = new EarSetEncapsulator(ears);
        builder.withEars(encapsulator.stateSetBuilder);
        return this;
    }

    public MonsterEncapsulator withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public MonsterEncapsulator withOptionalEars(EarEncapsulator... optionalEars) {
        EarListEncapsulator encapsulator = new EarListEncapsulator(optionalEars);
        builder.withOptionalEars(encapsulator.stateListBuilder);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}

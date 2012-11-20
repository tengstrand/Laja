package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarListEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;

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
        BrowListEncapsulator encapsulator = new BrowListEncapsulator(brows);
        builder.withBrows(encapsulator.stateList);
        return this;
    }

    public MonsterEncapsulator withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public MonsterEncapsulator withEars(EarEncapsulator... ears) {
        EarListEncapsulator encapsulator = new EarListEncapsulator(ears);
        builder.withEars(encapsulator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}

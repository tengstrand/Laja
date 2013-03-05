package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.behaviour.head.HeadBuilder;
import net.sf.laja.cdd.behaviour.arm.ArmBuilder;

public class MonsterBuilder {
    public final MonsterStateBuilder builder;

    public MonsterBuilder() {
        builder = MonsterStateImpl.build();
    }

    public MonsterBuilder(MonsterState state) {
        builder = new MonsterStateBuilderImpl(state);
    }

    public MonsterBuilder(MonsterState state, Object encapsulator) {
        builder = new MonsterStateBuilderImpl(state, encapsulator);
    }

    public MonsterBuilder withNumberOfLegs(int numberOfLegs) {
        builder.withNumberOfLegs(numberOfLegs);
        return this;
    }

    public MonsterBuilder withNumberOfOwnWings(int numberOfOwnWings) {
        builder.withNumberOfOwnWings(numberOfOwnWings);
        return this;
    }

    public MonsterBuilder withHead(HeadBuilder head) {
        builder.withHead(head.builder);
        return this;
    }

    public MonsterBuilder withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public MonsterBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public MonsterBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public MonsterBuilder withDecease(String decease) {
        builder.withDecease(decease);
        return this;
    }

    public MonsterBuilder withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
        return this;
    }

    public MonsterBuilder withHeadWeight(double headWeight) {
        builder.withHeadWeight(headWeight);
        return this;
    }

    public MonsterBuilder withLeftArm(ArmBuilder leftArm) {
        builder.withLeftArm(leftArm.builder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Monster asMonster() {
        return (Monster)builder.as(new MonsterFactory.MonsterFactory_());
    }
}

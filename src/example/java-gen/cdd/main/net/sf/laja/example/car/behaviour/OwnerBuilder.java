package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.OwnerState;
import net.sf.laja.example.car.state.OwnerStateBuilder;
import net.sf.laja.example.car.state.OwnerStateBuilderImpl;
import net.sf.laja.example.car.state.OwnerStateImpl;

public class OwnerBuilder {
    public final OwnerStateBuilder builder;

    public OwnerBuilder() {
        builder = OwnerStateImpl.build();
    }

    public OwnerBuilder(OwnerState state) {
        builder = new OwnerStateBuilderImpl(state);
    }

    public OwnerBuilder(OwnerState state, Object encapsulator) {
        builder = new OwnerStateBuilderImpl(state, encapsulator);
    }

    public OwnerBuilder withSsn(long ssn) {
        builder.withSsn(ssn);
        return this;
    }

    public OwnerBuilder withSsn(String ssn) {
        builder.withSsn(ssn);
        return this;
    }

    public OwnerBuilder withName(String name) {
        builder.withName(name);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Owner asOwner() {
        return (Owner)builder.as(new OwnerFactory.OwnerFactory_(builder));
    }
}

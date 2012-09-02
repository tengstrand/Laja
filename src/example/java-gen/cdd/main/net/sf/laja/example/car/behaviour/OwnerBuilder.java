package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerBuilder {
    public final OwnerStateBuilder builder;

    public OwnerBuilder() {
        builder = OwnerStateImpl.build();
    }

    public OwnerBuilder(OwnerState state) {
        builder = OwnerStateImpl.build(state);
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

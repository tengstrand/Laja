package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;

public class AddressIntegratorTemplate {
    AddressMutableState state;

    public DefaultAddress asAddress() {
        return new DefaultAddress(state.asImmutable());
    }
}

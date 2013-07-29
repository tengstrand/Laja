package net.sf.laja.cdd.testgen;

import static net.sf.laja.cdd.testgen.ProtectedAddress.ProtectedAddressException;
import static net.sf.laja.cdd.testgen.state.AddressState.AddressMutableState;

public class SpecialAddress extends SpecialAddressCreator.AddressMutableBehaviour implements Address {
    private AddressMutableState state;

    public SpecialAddress(AddressMutableState state) {
        super(state);
        this.state = state;
    }

    public boolean isFromUppsala() {
        throw new ProtectedAddressException();
    }
}

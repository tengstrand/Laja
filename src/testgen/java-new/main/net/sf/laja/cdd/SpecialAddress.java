package net.sf.laja.cdd;

import static net.sf.laja.cdd.ProtectedAddress.ProtectedAddressException;
import static net.sf.laja.cdd.SpecialAddressCreator.AddressMutableBehaviour;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class SpecialAddress extends AddressMutableBehaviour implements Address {
    private AddressMutableState state;

    public SpecialAddress(AddressMutableState state) {
        super(state);
        this.state = state;
    }

    public boolean isFromUppsala() {
        throw new ProtectedAddressException();
    }
}

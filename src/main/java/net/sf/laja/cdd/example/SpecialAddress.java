package net.sf.laja.cdd.example;

import static net.sf.laja.cdd.example.ProtectedAddress.ProtectedAddressException;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

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

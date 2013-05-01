package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

public class ProtectedAddress extends AddressCreator.AddressBehaviour implements Address {

    public ProtectedAddress(AddressState state) {
        super(state);
    }

    public boolean isFromUppsala() {
        throw new ProtectedAddressException();
    }

    public static class ProtectedAddressException extends RuntimeException { }
}

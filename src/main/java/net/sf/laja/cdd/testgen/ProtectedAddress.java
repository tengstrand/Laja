package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.state.AddressState;

import static net.sf.laja.cdd.testgen.AddressCreator.AddressBehaviour;

public class ProtectedAddress extends AddressBehaviour implements Address {

    public ProtectedAddress(AddressState state) {
        super(state);
    }

    public boolean isFromUppsala() {
        throw new ProtectedAddressException();
    }

    public static class ProtectedAddressException extends RuntimeException { }

    @Override public String toString() {
        return "ProtectedAddress" + state.withCity("?").withStreetName("?");
    }
}

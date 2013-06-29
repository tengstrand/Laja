package net.sf.laja.cdd.example;

import net.sf.laja.cdd.state.AddressState;

import static net.sf.laja.cdd.example.AddressCreator.AddressBehaviour;

public class ProtectedAddress extends AddressBehaviour implements Address {

    public ProtectedAddress(AddressState s) {
        super(s);
    }

    public boolean isFromUppsala() {
        throw new ProtectedAddressException();
    }

    public static class ProtectedAddressException extends RuntimeException { }

    @Override public String toString() {
        return "ProtectedAddress" + s.withCity("?").withStreetName("?");
    }
}

package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;

public class AddressFactory {

    public static AddressIntegrator streetName(String streetName) {
        return new Factory().new StreetName().streetName(streetName);
    }

    private static class Factory {
        private final AddressMutableState state = new AddressMutableState();

        public class StreetName {
            public AddressIntegrator streetName(String streetName) {
                state.streetName = streetName;
                return new AddressIntegrator(state);
            }
        }
    }
}

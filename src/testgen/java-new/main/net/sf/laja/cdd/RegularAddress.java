package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

import static net.sf.laja.cdd.AddressCreator.AddressBehaviour;

public class RegularAddress extends AddressBehaviour implements Address {

    public RegularAddress(AddressState state) {
        super(state);
    }

    public boolean isFromUppsala() {
        return "Uppsala".equals(state.city);
    }
}

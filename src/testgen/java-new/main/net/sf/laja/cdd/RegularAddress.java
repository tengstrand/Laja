package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.state.AddressState;

import static net.sf.laja.cdd.AddressCreator.AddressBehaviour;

@Behaviour
public class RegularAddress extends AddressBehaviour implements Address {

    public RegularAddress(AddressState s) {
        super(s);
    }

    public boolean isFromUppsala() {
        return "Uppsala".equals(s.city);
    }
}

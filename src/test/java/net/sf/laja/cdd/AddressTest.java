package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;
import net.sf.laja.cdd.testgen.Address;
import net.sf.laja.cdd.testgen.AddressType;
import net.sf.laja.cdd.testgen.ValidationErrors;
import org.junit.Test;

import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static net.sf.laja.cdd.testgen.ProtectedAddress.ProtectedAddressException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTest {

    @Test
    public void equalObjectsShouldMatch() throws Exception {
        Address address1 = createAddress().withStreetName("First street").asAddress();
        Address address2 = createAddress().withStreetName("First street").asAddress();

        assertThat(address1, equalTo(address2));
    }

    @Test
    public void addressIsFromUppsala() {
        Address address = createAddress().withStreetName("First street").withCity("Uppsala").asAddress();

        assertThat(address.isFromUppsala(), is(true));
    }

    @Test
    public void addressIsNotFromUppsala() {
        Address address = createAddress().withStreetName("First street").withCity("Stockholm").asAddress();

        assertThat(address.isFromUppsala(), is(false));
    }

    @Test (expected = ProtectedAddressException.class)
    public void accessingMethodOnProtectedAddressShouldThrowException() {
        Address address = createAddress().withStreetName("First street").withCity("Stockholm").asAddress(AddressType.PROTECTED);
        address.isFromUppsala();
    }

    @Test
    public void shouldBePossibleToValidateBeforeEncapsulation() {
        AddressBuilder builder = buildAddress();

        ValidationErrors errors = builder.validate();

        if (errors.isInvalid() && errors.first().isNullError(AddressState.STREET_NAME)) {
            builder.withStreetName("First street");
        }
        builder.assertIsValid();
    }
}

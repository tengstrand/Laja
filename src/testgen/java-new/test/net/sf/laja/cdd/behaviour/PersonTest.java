package net.sf.laja.cdd.behaviour;

import org.joda.time.DateMidnight;
import org.junit.Test;

import java.util.Map;

import static net.sf.laja.cdd.AddressCreator.buildAddress;
import static net.sf.laja.cdd.PersonCreator.*;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void hasShortName() {
        assertThat(defaultPerson().withName("Carl").asPerson().hasLongName(), is(false));
    }

    @Test
    public void hasLongName() {
        assertThat(defaultPerson().withName("Angelique").asPerson().hasLongName(), is(true));
    }

    @Test
    public void preserveHandWrittenChainedAttributes() {
        createPerson().name("Carl").birthday(1991,2,3).children().defaultAddress();
    }

    @Test
    public void convertToData() {
        Map data = buildPerson().withName("Carl").withAddress(buildAddress().withCity("Uppsala")).getData();
        assertThat(data.toString(), is("{version=1, type=net.sf.laja.cdd.state.PersonState, attributes={name=Carl, children=[], address={version=1, type=net.sf.laja.cdd.state.AddressState, attributes={id=0, streetName=, city=Uppsala}}}}"));
    }

    @Test
    public void convertToDataWithDefaults() {
        Map data = defaultPerson().withName("Carl").withAddress(buildAddress().withCity("Uppsala")).getData();
        assertThat(data.toString(), is("{version=1, type=net.sf.laja.cdd.state.PersonState, attributes={name=Carl, birthday=936828000000, children=[], address={version=1, type=net.sf.laja.cdd.state.AddressState, attributes={id=0, streetName=, city=Uppsala}}}}"));
    }

    private PersonBuilder defaultPerson() {
        PersonBuilder builder = buildPerson()
                .withName("")
                .withBirthday(new DateMidnight(1999, 9, 9))
                .withChildren()
                .withAddress(AddressMutableState.create());
        return builder;
    }
}

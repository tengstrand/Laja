package net.sf.laja.cdd.state;

import org.joda.time.DateMidnight;
import org.junit.Test;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonStateTest {

    @Test
    public void shouldConvertFromImmutableToMutableState() {
        PersonState state = createPerson().name("Carl").birthday(1977,8,15)
                .hairColor(1).children(createPerson().name("Adam").birthday(2010,11,12).hairColor(1).children().defaults())
                .defaults().asState();

        PersonMutableState mutableState = state.asMutable();

        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").birthday(1977,8,15)
                .hairColor(1).children(createPerson().name("Adam").birthday(2010,11,12).hairColor(1).children().defaults())
                .defaultAddress()
                .defaultListOfSetOfMapOfIntegers()
                .withGroupedAddresses((createAddressMap(addressEntry("aaa", createAddress().withStreetName("First street")))))
                .asMutableState();

        PersonState state = mutableState.asImmutable();

        assertThat(mutableState.children.get(0).name, equalTo("Adam"));
        assertThat(mutableState.children.get(0).birthday, equalTo(new DateMidnight(2010,11,12)));
        assertThat(mutableState.groupedAddresses.get("aaa").streetName, equalTo("First street"));
        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));

        assertThat(state.children.get(0).name, equalTo("Adam"));
        assertThat(state.children.get(0).birthday, equalTo(new DateMidnight(2010,11,12)));
        assertThat(state.groupedAddresses.get("aaa").streetName, equalTo("First street"));
        assertThat(state.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }
}

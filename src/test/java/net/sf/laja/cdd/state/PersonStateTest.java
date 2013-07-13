package net.sf.laja.cdd.state;

import org.junit.Test;

import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static net.sf.laja.cdd.testgen.HairColor.BROWN;
import static net.sf.laja.cdd.testgen.PersonCreator.createPerson;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonStateTest {

    @Test
    public void shouldConvertFromImmutableToMutableState() {
        PersonState state = createPerson().name("Carl")
                .hairColor(BROWN).children(createPerson().name("Adam").hairColor(BROWN).children().defaults())
                .defaults().asState();

        PersonMutableState mutableState = state.asMutable();

        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl")
                .hairColor(BROWN).children(createPerson().name("Adam").hairColor(BROWN).children().defaults())
                .defaultAddress()
                .groupedAddresses((createAddressMap(addressEntry("aaa", createAddress().withStreetName("First street")))))
                .defaultListOfSetOfMapOfIntegers().asMutableState();

        PersonState state = mutableState.asImmutable();

        assertThat(mutableState.children.get(0).name, equalTo("Adam"));
        assertThat(mutableState.groupedAddresses.get("aaa").streetName, equalTo("First street"));
        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));

        assertThat(state.children.get(0).name, equalTo("Adam"));
        assertThat(state.groupedAddresses.get("aaa").streetName, equalTo("First street"));
        assertThat(state.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }
}
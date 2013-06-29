package net.sf.laja.cdd;

import org.joda.time.DateMidnight;
import org.junit.Test;

import static net.sf.laja.cdd.example.AddressCreator.buildAddress;
import static net.sf.laja.cdd.example.HairColor.BROWN;
import static net.sf.laja.cdd.example.PersonCreator.*;
import static net.sf.laja.cdd.state.PersonState.IllegalPersonStateException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void shouldBePossibleToBuildIllegalMutableState() {
        buildPerson().asMutableState();
    }

    @Test(expected = IllegalPersonStateException.class)
    public void shouldNotBePossibleToBuildIllegalImmutableState() {
        buildPerson().asState();
    }

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
        createPerson().name("Carl").hairColor(BROWN).children().defaultAddress();
    }

    private PersonBuilder defaultPerson() {
        return buildPerson()
                .withHairColor("RED")
                .withBirthday(new DateMidnight(1999, 9, 9))
                .withAddress(buildAddress().withCity("Stockholm").withStreetName("First street"));
    }
}

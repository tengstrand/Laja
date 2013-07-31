package net.sf.laja.cdd;

import net.sf.laja.cdd.testgen.AddressCreator;
import net.sf.laja.cdd.testgen.Person;
import net.sf.laja.cdd.testgen.PersonCreator;
import net.sf.laja.cdd.testgen.state.PersonState;
import org.joda.time.DateMidnight;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.testgen.AddressCreator.buildAddress;
import static net.sf.laja.cdd.testgen.AddressCreator.buildStringAddress;
import static net.sf.laja.cdd.testgen.HairColor.BROWN;
import static net.sf.laja.cdd.testgen.PersonCreator.*;
import static net.sf.laja.cdd.testgen.state.PersonState.InvalidPersonStateException;
import static net.sf.laja.cdd.testgen.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.testgen.state.PersonState.PersonStringState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void shouldBePossibleToBuildIllegalMutableState() {
        buildPerson().asMutableState();
    }

    @Test(expected = InvalidPersonStateException.class)
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

    @Test
    public void stringAsMutableState() {
        List<Set<Map<String,String>>> list = new ArrayList<Set<Map<String,String>>>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("a", "123");
        Set<Map<String,String>> set = new HashSet<Map<String,String>>();
        set.add(map);
        list.add(set);

        PersonMutableState mutableState = PersonCreator.buildStringPerson()
                .withName("Carl")
                .withBirthday("1977-07-07")
                .withListOfSetOfMapOfIntegers(list).asMutableState();

        Object value = mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("a");

        assertThat(value.getClass().getSimpleName(), equalTo("Integer"));
    }

    @Test
    public void stringToMutableToBehaviourRepresentation() {
        PersonStringState stringState = buildStringPerson().withName("Kalle").withHairColor("RED")
                .withAddress(buildStringAddress().withCity("Stockholm").withStreetName("First street")).asStringState();
        Person person = new Person(stringState.asImmutable());
    }
}

package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.testgen.state.PersonState;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static net.sf.laja.cdd.state.converter.CollectionCreator.Entry.createEntry;
import static net.sf.laja.cdd.state.converter.CollectionCreator.*;
import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static net.sf.laja.cdd.testgen.HairColor.BLACK;
import static net.sf.laja.cdd.testgen.HairColor.BROWN;
import static net.sf.laja.cdd.testgen.PersonCreator.*;
import static net.sf.laja.cdd.testgen.state.PersonState.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
        assertThat(defaultPerson().asPerson().hasLongName(), is(false));
    }

    @Test
    public void hasLongName() {
        assertThat(defaultPerson().withName("Angelique").asPerson().hasLongName(), is(true));
    }

    @Test
    public void preserveHandWrittenChainedAttributes() {
        createPerson().name("Carl").hairColor(BROWN).children().defaultAddress();
    }

    @Test
    public void stringAsMutableState() {
        List list = createList(createSet(createMap(createEntry("a", "123"))));

        PersonMutableState mutableState = PersonCreator.buildPersonFromStrings()
                .withName("Carl")
                .withDateOfBirth("1977-07-07")
                .withListOfSetOfMapOfIntegers(list).asMutableState();

        Object value = mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("a");

        assertThat(value.getClass().getSimpleName(), equalTo("Integer"));
    }

    @Test(expected = InvalidPersonStateException.class)
    public void invalidStateShouldThrowException() {
        defaultPerson().withAddress(buildAddress().withCity("Uppsala")).asPerson();
    }

    @Test
    public void convertFromVersion2ToVersion1AndBackAgain() {
        Map person1 = convertFromVersion2ToVersion1(defaultPerson());
        PersonMutableState person2 = convertFromVersion1ToVersion2(person1);
    }

    private Map convertFromVersion2ToVersion1(PersonBuilder person) {
        Map map = person.asMap();

        map.put("birthday", map.get(PersonState.DATE_OF_BIRTH));
        map.remove("dateOfBirth");

        return map;
    }

    private PersonMutableState convertFromVersion1ToVersion2(Map person) {
        person.put(PersonState.DATE_OF_BIRTH, person.get("birthday"));
        person.remove("birthday");

        return PersonCreator.createPersonFromMap(person).asMutableState();
    }

    @Test
    public void convertToMapAndBackAgain() {
        PersonBuilder person = defaultPerson()
                .withChildren(createPersonSet(createPerson().name("Anders").hairColor(BLACK).children().defaults()))
                .withAddress(buildAddress().withId(2).withStreetName("Third street").withCity("Stockholm"))
                .withOldAddress(buildAddress().withId(3))
                .withOldAddresses(createAddressSet(defaultAddress(4)))
                .withGroupedAddresses(createAddressFromMap(createAddressEntry("abc", defaultAddress(5))))
                .withListOfSetOfState(createList(createSet(defaultAddress(6).asMutableState())))
                .withListOfSetOfMapOfIntegers(createList(createSet(mapOfIntegers())));

        Map map = person.asMap();
        PersonMutableState mutableState = person.asMutableState();
        PersonMutableState converted = createPersonFromMap(map).asMutableState();

        assertThat(converted.id, equalTo(mutableState.id));
        assertThat(converted.name, equalTo(mutableState.name));
        assertThat(converted.dateOfBirth, equalTo(mutableState.dateOfBirth));
        assertThat(converted.hairColor, equalTo(mutableState.hairColor));
        assertThat(converted.children, equalTo(mutableState.children));
        assertThat(converted.address, equalTo(mutableState.address));
        assertThat(converted.oldAddress, equalTo(mutableState.oldAddress));
        assertThat(converted.oldAddresses, equalTo(mutableState.oldAddresses));
        assertThat(converted.groupedAddresses, equalTo(mutableState.groupedAddresses));
        assertThat(converted.listOfSetOfState, equalTo(mutableState.listOfSetOfState));
        assertThat(converted.listOfSetOfMapOfIntegers, equalTo(mutableState.listOfSetOfMapOfIntegers));
    }

    private static Map mapOfIntegers() {
        return createMap(createEntry("key1", 123), createEntry("key2", 456));
    }

    @Test
    public void stringToMutableToBehaviourRepresentation() {
        PersonStringState stringState = buildPersonFromStrings()
                        .withAddress(buildAddressFromStrings()
                        .withCity("Stockholm")
                        .withStreetName("First street"))
                        .withChildren()
                        .withGroupedAddresses()
                        .withListOfSetOfMapOfIntegers(createList()).asStringState();
        try {
            new Person(stringState.asImmutable());
            fail();
        } catch (InvalidPersonStateException e) {
            assertThat(e.getMessage(), equalTo("[ValidationError{attribute='name', errorType='NULL', errorMessage='Attribute 'name' can not be NULL'}, ValidationError{attribute='hairColor', errorType='NULL', errorMessage='Attribute 'hairColor' can not be NULL'}]"));
        }
    }

    private AddressCreator defaultAddress(int id) {
        return createAddress().withId(id).withStreetName("Second street").withCity("Uppsala");
    }

    private PersonBuilder defaultPerson() {
        return buildPerson()
                .withId(99)
                .withName("Carl")
                .withHairColor("RED")
                .withDateOfBirth(1999, 10, 11)
                .withAddress(buildAddress().withId(1).withStreetName("First street").withCity("Stockholm"))
                .withChildren()
                .withGroupedAddresses()
                .withListOfSetOfMapOfIntegers(createList());
    }
}

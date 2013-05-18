package net.sf.laja.cdd.state;

import net.sf.laja.cdd.AddressCreator;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import org.junit.Test;

import java.util.Iterator;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonMutableStateTest {

    @Test
    public void shouldNotBeValidIfValidatingWithMissingAddress() {
        PersonMutableState state = buildPerson().withName("Carl").asMutableState();

        assertThat(state.isValid(), is(false));
    }

    @Test
    public void shouldReturnIsNullValidationErrors() {
        PersonMutableState mutableState = buildPerson().withName("Carl").asMutableState();
        ValidationErrors errors = mutableState.validate();

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(mutableState, "birthday")
                .addIsNullError(mutableState, "address", "streetName").build();

        assertThat(errors, equalTo(expectedErrors));
    }

    @Test
    public void invalidCollectionShouldReturnIsNullValidationErrors() {
        PersonMutableState mutableState = createPerson().name(null).birthday(1988, 8, 8).children(
                createPerson().name(null).birthday(2010, 10, 10).children().defaults(),
                createPerson().name(null).birthday(2011, 11, 11).children().defaults()
        ).defaults().asMutableState();

        ValidationErrors errors = mutableState.validate();
        Iterator<ValidationErrors.ValidationError> iterator = errors.iterator();

        assertThat(errors.size(), is(2));
        assertThat(iterator.next(), equalTo(new ValidationErrors.ValidationError("name", "is_null", mutableState)));
        assertThat(iterator.next(), equalTo(new ValidationErrors.ValidationError("children.name", "is_null", mutableState)));
    }

    @Test
    public void invalidStateShouldReturnCustomValidationError() {
        PersonMutableState mutableState = createPerson().name("Carl").birthday(1988, 8, 8).children()
                .address(AddressCreator.createAddress().streetName("First street").withCity("Stockholm"))
                .defaultListOfSetOfMapOfIntegers().asMutableState();

        ValidationErrors errors = mutableState.validate(new CarlCanNotLiveInStockholmValidator());

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addError(mutableState, "address", "carl_can_not_live_in_stockholm").build();

        assertThat(errors, equalTo(expectedErrors));
    }

    static class CarlCanNotLiveInStockholmValidator implements Validator<PersonState.PersonMutableState> {

        public void validate(Object rootElement, PersonMutableState state, String parent, String attribute, ValidationErrors.Builder errors) {
            if ("Carl".equals(state.name) && state.address != null && "Stockholm".equals(state.address.city)) {
                errors.addError(rootElement, parent, "address", "carl_can_not_live_in_stockholm");
            }
        }
    }
}
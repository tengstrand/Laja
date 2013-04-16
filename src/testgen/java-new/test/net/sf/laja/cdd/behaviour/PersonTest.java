package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.Person;
import org.junit.Test;

import static net.sf.laja.cdd.PersonIntegrator.buildPerson;
import static net.sf.laja.cdd.PersonIntegrator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonStringState;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void hasShortName() {
        assertThat(buildPerson().withName("Carl").asPerson().hasLongName(), is(false));
    }

    @Test
    public void hasLongName() {
        assertThat(buildPerson().withName("Angelique").asPerson().hasLongName(), is(true));
    }

    @Test
    public void defaults() {
        Person person = createPerson().defaults().asPerson();
    }

    @Test
    public void convertToStringState() {
        PersonStringState personState = createPerson().name("Carl").birthday(1977,7,7).defaults().getStringState();
        System.out.println(personState);
    }
}

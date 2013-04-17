package net.sf.laja.cdd.behaviour;

import org.junit.Test;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.PersonCreator.createPerson;
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
    public void preserveHandWrittenChainedAttributes() {
        createPerson().name("Carl").birthday(1991,2,3).children().defaultAddress();
    }

    @Test
    public void convertToStringState() {
        PersonStringState personState = buildPerson().withName("Carl").getStringState();
        System.out.println(personState);
    }
}

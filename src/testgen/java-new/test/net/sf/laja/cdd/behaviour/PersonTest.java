package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.Data;
import org.junit.Test;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.PersonCreator.createPerson;
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
    public void convertToData() {
        Data data = buildPerson().withName("Carl").getData();
        assertThat(data.toString(), is("Data{version=1, type=net.sf.laja.cdd.state.PersonState.PersonMutableState, attributes={name=Carl, birthday=1366149600000, children=[], address=Data{version=1, type=net.sf.laja.cdd.state.AddressState.AddressMutableState, attributes={id=0, streetName=, city=}}}}"));
    }
}

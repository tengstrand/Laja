package net.sf.laja.cdd;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static net.sf.laja.cdd.HairColor.BROWN;
import static net.sf.laja.cdd.PersonCreator.createPerson;

public class TextPersonTest {

    @Test
    public void ensureTwoInstancesFromDifferentContextIsEqual() {
        PersonCreator creator = createPerson().name("Carl").hairColor(BROWN).children().defaults();

        TextPerson textPerson = creator.asTextPerson();
        SpecialPerson specialPerson = creator.asSpecialPerson();

        assertEquals(textPerson, specialPerson);
    }
}

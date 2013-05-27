package net.sf.laja.cdd;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static net.sf.laja.cdd.PersonCreator.createPerson;

public class TextPersonTest {

    @Test
    public void ensureTwoInstancesFromDifferentContextIsEqual() {
        PersonCreator creator = createPerson().name("Carl").birthday(1999,9,9).hairColor(1).children().defaults();

        TextPerson textPerson = creator.asTextPerson();
        DbPerson dbPerson = creator.asDbPerson();

        assertEquals(textPerson, dbPerson);
    }
}

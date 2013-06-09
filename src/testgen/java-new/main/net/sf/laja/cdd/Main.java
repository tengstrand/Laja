package net.sf.laja.cdd;

import static net.sf.laja.cdd.PersonCreator.createPerson;

public class Main {
    public static void main(String[] args) {
        PersonCreator.PersonFactory personFactory = createPerson();
        PersonCreator personCreator = personFactory.name("kalle").hairColor("RED").children().defaults();

        personCreator.isValid();
        personCreator.validate();
        personCreator.assertIsValid();

        personCreator.asPerson();
        personCreator.asDbPerson();
        personCreator.asTextPerson();
        personCreator.asSpecialPerson();
        personCreator.asState();
        personCreator.asMutableState();
    }
}

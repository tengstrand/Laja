package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

import static net.sf.laja.cdd.PersonCreator.PersonBehaviour;

public class DbPerson extends PersonBehaviour {

    public DbPerson(PersonState state) {
        super(state);
    }

    public String getInsertStatement() {
        // Use prepared statements...
        return "insert into person (name, birthday, address) values('" + state.name + "', ...)";
    }
}

package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.testgen.state.PersonState;

@Behaviour
public class DbPerson extends PersonCreator.PersonBehaviour {

    public DbPerson(PersonState state) {
        super(state);
    }

    public String getInsertStatement() {
        // Use prepared statements...
        return "insert into person (name, birthday, address) values('" + state.name + "', ...)";
    }
}

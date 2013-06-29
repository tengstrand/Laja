package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.state.PersonState;

@Behaviour
public class DbPerson extends PersonCreator.PersonBehaviour {

    public DbPerson(PersonState s) {
        super(s);
    }

    public String getInsertStatement() {
        // Use prepared statements...
        return "insert into person (name, birthday, address) values('" + s.name + "', ...)";
    }
}

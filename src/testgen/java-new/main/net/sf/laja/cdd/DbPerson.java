package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

public class DbPerson {
    public final PersonState state;

    public DbPerson(PersonState state) {
        this.state = state;
    }

    public String getInsertStatement() {
        // Use prepared statements...
        return "insert into person (name, birthday, address) values('" + state.name + "', ...)";
    }
}

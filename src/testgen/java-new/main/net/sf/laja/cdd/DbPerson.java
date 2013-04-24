package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

public class DbPerson {
    public final PersonState state;

    public DbPerson(PersonState state) {
        this.state = state;
    }

    /*
    public final String name;
    public final DateMidnight birthday;
    public final ImmutableList<PersonState> children;
    public final AddressState address;
    public final ImmutableSet<AddressState> oldAddresses; // (optional)
    public final ImmutableMap<String,AddressState> groupedAddresses; // (optional)

     */

    public String getInsertStatement() {
        // Use prepared statements...
        return "insert into person (name, birthday, address) values('" + state.name + "', ...)";
    }
}

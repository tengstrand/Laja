package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.Creator;

import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

@Creator
public class DbPersonCreator {
    PersonMutableState state;

    public DbPerson asDbPerson() {
        return new DbPerson(state.asImmutable());
    }
}

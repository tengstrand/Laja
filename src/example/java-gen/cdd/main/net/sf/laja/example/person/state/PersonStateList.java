package net.sf.laja.example.person.state;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface PersonStateList extends List<PersonState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}

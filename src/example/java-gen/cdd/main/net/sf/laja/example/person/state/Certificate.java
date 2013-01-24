package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.BmiStateImpl;
import net.sf.laja.example.person.state.BmiStateListImpl;
import net.sf.laja.example.person.state.BmiStateBuilderImpl;
import net.sf.laja.example.person.state.HeightStateImpl;
import net.sf.laja.example.person.state.HeightStateListImpl;
import net.sf.laja.example.person.state.HeightStateBuilderImpl;
import net.sf.laja.example.person.state.PersonStateImpl;
import net.sf.laja.example.person.state.PersonStateListImpl;
import net.sf.laja.example.person.state.PersonStateBuilderImpl;

/**
 * Code generated by Laja - Do not change!
 * Version: laja2-006-alpha
 *
 *   http://laja.tengstrand.nu
 */
public final class Certificate {
    Certificate() {
    }

    private static Certificate certificate(Object state) {
        if (state == null) {
            throw new IllegalArgumentException();
        }
        return new Certificate();
    }

    public static Certificate get(BmiStateImpl state) { return certificate(state); }
    public static Certificate get(BmiStateListImpl state) { return certificate(state); }
    public static Certificate get(BmiStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(HeightStateImpl state) { return certificate(state); }
    public static Certificate get(HeightStateListImpl state) { return certificate(state); }
    public static Certificate get(HeightStateBuilderImpl state) { return certificate(state); }

    public static Certificate get(PersonStateImpl state) { return certificate(state); }
    public static Certificate get(PersonStateListImpl state) { return certificate(state); }
    public static Certificate get(PersonStateBuilderImpl state) { return certificate(state); }
}

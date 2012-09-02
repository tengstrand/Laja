package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.CustomerStateImpl;
import net.sf.laja.example.repository.state.CustomerStateListImpl;
import net.sf.laja.example.repository.state.CustomerStateBuilderImpl;
import net.sf.laja.example.repository.state.AddressStateImpl;
import net.sf.laja.example.repository.state.AddressStateListImpl;
import net.sf.laja.example.repository.state.AddressStateBuilderImpl;
import net.sf.laja.example.repository.state.ZipcodeStateImpl;
import net.sf.laja.example.repository.state.ZipcodeStateListImpl;
import net.sf.laja.example.repository.state.ZipcodeStateBuilderImpl;

/**
 * Code generated by Laja - Do not change!
 * Version: laja2-006
 *
 *   http://laja.sf.net
 */
public class Certificate {
    Certificate() {
    }

    public static Certificate get(CustomerStateImpl state) { return new Certificate(); }
    public static Certificate get(CustomerStateListImpl state) { return new Certificate(); }
    public static Certificate get(CustomerStateBuilderImpl state) { return new Certificate(); }

    public static Certificate get(AddressStateImpl state) { return new Certificate(); }
    public static Certificate get(AddressStateListImpl state) { return new Certificate(); }
    public static Certificate get(AddressStateBuilderImpl state) { return new Certificate(); }

    public static Certificate get(ZipcodeStateImpl state) { return new Certificate(); }
    public static Certificate get(ZipcodeStateListImpl state) { return new Certificate(); }
    public static Certificate get(ZipcodeStateBuilderImpl state) { return new Certificate(); }
}

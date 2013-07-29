package net.sf.laja.cdd.state;

import java.io.Serializable;

public interface ImmutableState extends Serializable {
    net.sf.laja.cdd.testgen.MutableState asMutable();
}

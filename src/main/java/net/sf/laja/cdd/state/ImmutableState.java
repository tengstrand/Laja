package net.sf.laja.cdd.state;

import java.io.Serializable;

public interface ImmutableState extends Serializable {
    MutableState asMutable();
}

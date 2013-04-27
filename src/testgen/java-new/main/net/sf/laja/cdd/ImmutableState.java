package net.sf.laja.cdd;

import java.io.Serializable;

public interface ImmutableState extends Serializable {
    MutableState asMutable();
}

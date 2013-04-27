package net.sf.laja.cdd;

import java.io.Serializable;

public interface MutableState extends Serializable {
    ImmutableState asImmutable();
}

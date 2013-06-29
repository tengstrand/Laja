package net.sf.laja.cdd.testgen;

import java.io.Serializable;

public interface ImmutableState extends Serializable {
    MutableState asMutable();
}

package net.sf.laja.cdd.example;

import java.io.Serializable;

public interface ImmutableState extends Serializable {
    MutableState asMutable();
}

package net.sf.laja.cdd.behaviour.hair;

import java.util.List;

public interface HairList extends List<Hair> {
    FakeHairArrayList asFakeHairList();
}
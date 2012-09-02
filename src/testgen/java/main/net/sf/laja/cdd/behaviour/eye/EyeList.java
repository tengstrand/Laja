package net.sf.laja.cdd.behaviour.eye;

import java.util.List;

public class EyeList extends EyeAbstractList {
    public EyeList(Eye... list) {
        super(list);
    }

    public EyeList(List<Eye> list) {
        super(list);
    }
}
package net.sf.laja.cdd.behaviour.scaryeye;

import java.util.List;

public class ScaryEyeList extends ScaryEyeArrayList {
    public ScaryEyeList(ScaryEye... list) {
        super(list);
    }

    public ScaryEyeList(List<ScaryEye> list) {
        super(list);
    }
}

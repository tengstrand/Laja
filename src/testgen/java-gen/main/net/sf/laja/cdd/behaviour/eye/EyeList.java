package net.sf.laja.cdd.behaviour.eye;

import java.util.List;

import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEyeArrayList;

public interface EyeList extends List<Eye> {
    ScaryEyeArrayList asScaryEyeList();
}

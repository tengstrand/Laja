package net.sf.laja.cdd.behaviour.eye;

import java.util.Set;

import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEyeSet;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEyeHashSet;

public interface EyeSet extends Set<Eye> {
    ScaryEyeSet asScaryEyeSet();
}

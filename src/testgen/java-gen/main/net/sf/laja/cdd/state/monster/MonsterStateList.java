package net.sf.laja.cdd.state.monster;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface MonsterStateList extends List<MonsterState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}

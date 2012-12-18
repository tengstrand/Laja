package net.sf.laja.cdd.state.monster;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MonsterStateListImpl extends ArrayList<MonsterState> implements MonsterStateList {
    private boolean _encapsulated = false;

    public MonsterStateListImpl() {
    }

    public MonsterStateListImpl(int size) {
        super(size);
    }

    public static MonsterStateList emptyList() {
        return new MonsterStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (MonsterState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (MonsterState state : this) {
            state.encapsulate();
        }
    }
}

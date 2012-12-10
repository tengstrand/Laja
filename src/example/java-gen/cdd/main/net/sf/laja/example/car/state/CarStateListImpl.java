package net.sf.laja.example.car.state;

import java.util.*;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class CarStateListImpl extends ArrayList<CarState> implements CarStateList {
    private boolean _encapsulated = false;

    public CarStateListImpl() {
    }

    public static CarStateList emptyList() {
        return new CarStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (CarState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate() {
        _encapsulated = true;

        for (CarState state : this) {
            state.encapsulate();
        }
    }
}

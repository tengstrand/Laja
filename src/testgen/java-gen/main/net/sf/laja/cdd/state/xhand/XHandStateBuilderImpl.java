package net.sf.laja.cdd.state.xhand;

import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.finger.FingerBehaviourFactory;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailBehaviourFactory;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class XHandStateBuilderImpl implements XHandStateBuilder {
    private Object encapsulator;
    private XHandState state;
    private final Certificate certificate;

    XHandStateBuilderImpl() {
        state = new XHandStateImpl();
        certificate = Certificate.get(this);
    }

    public XHandStateBuilderImpl(XHandState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public XHandStateBuilderImpl(XHandState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withColor(String color) {
        state.setColor(color, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(XHandBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(FingerBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(NailBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public XHandState getXHandState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    public FingerState getFingerState(Certificate certificate) {
        return state;
    }

    public NailState getNailState(Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof XHandStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
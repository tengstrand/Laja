package net.sf.laja.cdd.behaviour.xhand;

import net.sf.laja.cdd.state.xhand.XHandState;

public class XHand extends XHandFactory {
    public XHand(XHandState state) {
        super(state);
    }

    // (factory)
    public XHand asXHand() {
        return new XHand(state);
    }
}

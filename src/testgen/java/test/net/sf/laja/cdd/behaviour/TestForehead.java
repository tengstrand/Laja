package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.behaviour.ear.Ear;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;
import net.sf.laja.cdd.behaviour.ear.EarSet;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.forehead.ForeheadState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestForehead extends TestForeheadFactory {
    public TestForehead(ForeheadState state) {
        super(state);

        // Needed to populate hidden field in Brow.
        new BrowArrayList(state.getBrows());
        new EarHashSet(state.getEars());
    }

    // (factory)
    public TestForehead asTestForehead() {
        return new TestForehead(state);
    }

    public TestBrowList removeBrow(int index) {
        TestBrowList browList = new TestBrowArrayList(state.getBrows());
        browList.remove(index);
        return browList;
    }

    private Ear ear(int weight) {
        return Ear.weight(weight).asEar();
    }

    private EarState earState(int weight) {
        EarState earState = Ear.weight(weight).asEar().getState(state.certificate());
        return earState;
    }

    public EarSet getEars() {
        return new EarHashSet(state.getEars());
    }

    public void removeEar(Ear ear) {
        Set<EarState> states = new HashSet<EarState>();
        states.add(earState(1));
        states.add(earState(2));
        states.add(earState(3));

        states.remove(earState(2));

        EarSet set = new EarHashSet(state.getEars());
        set.remove(ear(2));

    }

    public List<Integer> earWeights() {
        List<Integer> result = new ArrayList();
        for (EarState earState : state.getEars()) {
            result.add(earState.getWeight());
        }
        return result;
    }
}

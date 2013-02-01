package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.ear.Ear;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;
import net.sf.laja.cdd.behaviour.ear.EarList;
import net.sf.laja.cdd.behaviour.ear.EarSet;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test set operations.
 */
public class SetTest {

    private EarEncapsulator ear(int weight) {
        return Ear.weight(weight);
    }

    private EarWeightSet createEarSet() {
        EarSet set = Ear.createSet(ear(1), ear(2), ear(3)).asEarSet();
        return new EarWeightSet(set);
    }

    @Test
    public void remove_createdFromVarargConstructor() {
        EarWeightSet set = createEarSet();

        set.remove(ear(2).asEar());

        assertEquals(Arrays.asList(1, 3), set.weights());
    }

    @Test
    public void remove_createdFromSet() {
        EarWeightSet set = createEarSet();

        set.remove(ear(2).asEar());

        assertEquals(Arrays.asList(1, 3), set.weights());
    }

    @Test
    public void remove_createdFromStateSet() {
        TestForehead forehead = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();

        forehead.removeEar(ear(2).asEar());

        assertEquals(Arrays.asList(1, 3), forehead.earWeights());
    }

    @Test
    public void size() {
        assertEquals(3, createEarSet().size());
    }

    @Test
    public void isEmpty() {
        assertTrue(new EarHashSet().isEmpty());
    }

    @Test
    public void isEmpty_false() {
        assertFalse(createEarSet().isEmpty());
    }

    @Test
    public void contains() {
        assertTrue(createEarSet().contains(ear(2).asEar()));
    }

    @Test
    public void contains_not() {
        assertFalse(createEarSet().contains(ear(4)));
    }

    @Test
    public void iterator() {
        Iterator<Ear> iterator = createEarSet().iterator();

        assertEquals(ear(1).asEar(), iterator.next());
    }

    @Test
    public void containsAll() {
        EarSet set = createEarSet();
        EarList list = Ear.createList(ear(1), ear(2), ear(3)).asEarList();

        assertTrue(set.containsAll(list));
    }

    @Test
    public void add() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1)).asTestForehead();
        forehead1.getEars().add(ear(2).asEar());
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet(ear(1), ear(2)).asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void addAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2)).asTestForehead();
        forehead1.getEars().addAll(Ear.createSet(ear(3), ear(4)).asEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet(ear(1), ear(2), ear(3), ear(4)).asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void remove() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().remove(ear(2).asEar());
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet(ear(1), ear(3)).asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void removeAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3), ear(4), ear(5)).asTestForehead();
        forehead1.getEars().removeAll(Ear.createSet(ear(3), ear(4)).asEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet(ear(1), ear(2), ear(5)).asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void retainAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().retainAll(Ear.createSet(ear(2), ear(3)).asEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet(ear(2), ear(3)).asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void clear() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().clear();
        TestForehead forehead2 = forehead1.asTestForehead();

        EarSet expectedSet = Ear.createSet().asEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }
}

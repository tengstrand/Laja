package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.ear.EarHashSet;
import net.sf.laja.cdd.behaviour.ear.EarList;
import net.sf.laja.cdd.behaviour.ear.EarSet;
import net.sf.laja.cdd.behaviour.ear.TheEar;
import net.sf.laja.cdd.behaviour.ear.TheEarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarList;
import net.sf.laja.cdd.behaviour.ear.TheEarSet;
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

    private TheEarEncapsulator ear(int weight) {
        return TheEar.weight(weight);
    }

    private EarWeightSet createEarSet() {
        TheEarSet set = TheEar.createSet(ear(1), ear(2), ear(3)).asTheEarSet();
        return new EarWeightSet(set);
    }

    @Test
    public void remove_createdFromVarargConstructor() {
        EarWeightSet set = createEarSet();

        set.remove(ear(2).asTheEar());

        assertEquals(Arrays.asList(1, 3), set.weights());
    }

    @Test
    public void remove_createdFromSet() {
        EarWeightSet set = createEarSet();

        set.remove(ear(2).asTheEar());

        assertEquals(Arrays.asList(1, 3), set.weights());
    }

    @Test
    public void remove_createdFromStateSet() {
        TestForehead forehead = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();

        forehead.removeEar(ear(2).asTheEar());

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
        assertTrue(createEarSet().contains(ear(2).asTheEar()));
    }

    @Test
    public void contains_not() {
        assertFalse(createEarSet().contains(ear(4)));
    }

    @Test
    public void iterator() {
        Iterator<TheEar> iterator = createEarSet().iterator();

        assertEquals(ear(1).asTheEar(), iterator.next());
    }

    @Test
    public void containsAll() {
        EarSet set = createEarSet();
        TheEarList list = TheEar.createList(ear(1), ear(2), ear(3)).asTheEarList();

        assertTrue(set.containsAll(list));
    }

    @Test
    public void add() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1)).asTestForehead();
        forehead1.getEars().add(ear(2).asTheEar());
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet(ear(1), ear(2)).asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void addAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2)).asTestForehead();
        forehead1.getEars().addAll(TheEar.createSet(ear(3), ear(4)).asTheEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet(ear(1), ear(2), ear(3), ear(4)).asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void remove() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().remove(ear(2).asTheEar());
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet(ear(1), ear(3)).asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void removeAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3), ear(4), ear(5)).asTestForehead();
        forehead1.getEars().removeAll(TheEar.createSet(ear(3), ear(4)).asTheEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet(ear(1), ear(2), ear(5)).asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void retainAll() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().retainAll(TheEar.createSet(ear(2), ear(3)).asTheEarSet());
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet(ear(2), ear(3)).asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }

    @Test
    public void clear() {
        TestForehead forehead1 = TestForehead.create().withEars(ear(1), ear(2), ear(3)).asTestForehead();
        forehead1.getEars().clear();
        TestForehead forehead2 = forehead1.asTestForehead();

        TheEarSet expectedSet = TheEar.createSet().asTheEarSet();

        assertEquals(expectedSet, forehead1.getEars());
        assertEquals(expectedSet, forehead2.getEars());
    }
}

package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.hair.FakeHairList;
import net.sf.laja.cdd.behaviour.hair.Hair;
import net.sf.laja.cdd.behaviour.hair.HairList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test list operations.
 */
public class ListTest {

    private TestBrowList createBrowList() {
        return TestBrow.createList(
                TestBrow.area(1),
                TestBrow.area(2),
                TestBrow.area(3)).asTestBrowList();
    }

    @Test
    public void remove_createdFromVarargConstructor() {
        TestBrowList list = createBrowList();

        list.remove(1);

        assertEquals(Arrays.asList(1,3), list.areas());
    }

    @Test
    public void remove_createdFromList() {
        List<TestBrow> brows = new ArrayList<TestBrow>();
        brows.add(TestBrow.area(1).asTestBrow());
        brows.add(TestBrow.area(2).asTestBrow());
        brows.add(TestBrow.area(3).asTestBrow());

        TestBrowList list = new TestBrowList(brows);

        list.remove(1);

        assertEquals(Arrays.asList(1, 3), list.areas());
    }

    @Test
    public void remove_createdFromStateList() {
        TestForehead forehead = TestForehead.create().withBrows(Brow.createList(Brow.area(1), Brow.area(2), Brow.area(3))
        ).asTestForehead();

        TestBrowList list = forehead.remove(1);

        TestBrowList expectedList = TestBrow.createList(
                TestBrow.area(1),
                TestBrow.area(3)
        ).asTestBrowList();

        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1, 3), list.areas());
   }

    @Test
    public void size() {
        assertEquals(3, createBrowList().size());
    }

    @Test
    public void isEmpty() {
        assertTrue(new TestBrowList().isEmpty());
    }

    @Test
    public void isEmpty_false() {
        assertFalse(createBrowList().isEmpty());
    }

    @Test
    public void contains() {
        TestBrow testBrow = TestBrow.area(2).asTestBrow();
        assertTrue(createBrowList().contains(testBrow));
    }

    @Test
    public void contains_not() {
        TestBrow testBrow = TestBrow.area(4).asTestBrow();
        assertFalse(createBrowList().contains(testBrow));
    }

    @Test
    public void iterator() {
        Iterator<TestBrow> iterator = createBrowList().iterator();
        TestBrow firstElement = TestBrow.area(1).asTestBrow();

        assertEquals(firstElement, iterator.next());
    }

    @Test
    public void add() {
        TestBrowList list = createBrowList();
        list.add(TestBrow.area(5).asTestBrow());

        assertEquals(Arrays.asList(1,2,3,5), list.areas());
    }

    @Test
    public void add_withIndex() {
        TestBrowList list = createBrowList();
        list.add(2, TestBrow.area(5).asTestBrow());

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(5).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );

        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1,2,5,3), list.areas());
    }

    @Test
    public void remove() {
        TestBrowList list = createBrowList();
        list.remove(TestBrow.area(2).asTestBrow());

        assertEquals(Arrays.asList(1, 3), list.areas());
    }

    @Test
    public void containsAll() {
        TestBrowList list = createBrowList();
        TestBrowList collection = new TestBrowList(
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );
        assertTrue(list.containsAll(collection));
    }

    @Test
    public void addAll() {
        TestBrowList list = createBrowList();
        TestBrowList collection = new TestBrowList(
                TestBrow.area(4).asTestBrow(),
                TestBrow.area(5).asTestBrow()
        );
        list.addAll(collection);

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow(),
                TestBrow.area(4).asTestBrow(),
                TestBrow.area(5).asTestBrow()
        );

        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1,2,3,4,5), list.areas());
    }

    @Test
    public void addAll_withIndex() {
        TestBrowList list = createBrowList();
        TestBrowList collection = new TestBrowList(
                TestBrow.area(4).asTestBrow(),
                TestBrow.area(5).asTestBrow()
        );
        list.addAll(1, collection);

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(4).asTestBrow(),
                TestBrow.area(5).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );

        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1,4,5,2,3), list.areas());
    }

    @Test
    public void removeAll() {
        TestBrowList list = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow(),
                TestBrow.area(4).asTestBrow(),
                TestBrow.area(5).asTestBrow(),
                TestBrow.area(6).asTestBrow()
        );
        TestBrowList removeList = new TestBrowList(
                TestBrow.area(3).asTestBrow(),
                TestBrow.area(4).asTestBrow()
        );
        list.removeAll(removeList);

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(5).asTestBrow(),
                TestBrow.area(6).asTestBrow()
        );
        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1, 2, 5, 6), list.areas());
    }

    @Test
    public void retainAll() {
        TestBrowList list = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow(),
                TestBrow.area(4).asTestBrow()
        );
        TestBrowList retainList = new TestBrowList(
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow(),
                TestBrow.area(5).asTestBrow()
        );

        list.retainAll(retainList);

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );
        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(2,3), list.areas());
    }

    @Test
    public void clear() {
        TestBrowList list = createBrowList();
        list.clear();

        assertEquals(0, list.size());
        assertEquals(Arrays.asList(), list.areas());
    }

    @Test
    public void get() {
        TestBrowList list = createBrowList();
        TestBrow expectedBrow = TestBrow.area(2).asTestBrow();

        assertEquals(expectedBrow, list.get(1));
        assertEquals(new Integer(2), list.areas().get(1));
    }

    @Test
    public void set() {
        TestBrowList list = createBrowList();
        list.set(1, TestBrow.area(5).asTestBrow());

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(5).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );
        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1,5,3), list.areas());
    }

    @Test
    public void remove_usingIndex() {
        TestBrowList list = createBrowList();
        list.remove(1);

        TestBrowList expectedList = new TestBrowList(
                TestBrow.area(1).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );
        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1,3), list.areas());
    }

    @Test
    public void removeViaOtherList() {
        TestMouthList testList = TestMouthFactory.createList(TestMouth.width(10).height(5).color("Red"),
                TestMouth.width(8).height(4).color("Blue")).asTestMouthList();

        testList.asCuteMouthList().remove(0);

        assertEquals(1, testList.stateSize());
    }

    @Test(expected = IllegalStateException.class)
    public void illegalStateIfListIsMutatedFromAnotherList() {
        TestMouthList testList = createTestMouthList();
        testList.asCuteMouthList().remove(0);
        testList.get(0);
    }

    @Test
    public void listIsMutatedFromAnotherListWithSyncState() {
        TestMouthList testList = createTestMouthList();
        testList.asCuteMouthList().remove(0);
        testList.syncState();
        testList.get(0);

        assertEquals(1, testList.size());
    }

    private TestMouthList createTestMouthList() {
        return TestMouthFactory.createList(TestMouth.width(10).height(5).color("Red"),
                TestMouth.width(8).height(4).color("Blue")).asTestMouthList();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tryRemoveElementViaValueBasedListHavingEntityBasedState() {
        final int length = 9;
        final String red = "Red";
        final String black = "Black";

        HairList hairList = Hair.createList(
                Hair.length(length).color(red),
                Hair.length(length).color(black)
        ).asHairList();

        hairList.remove(Hair.length(length).color(black).asHair());
    }
}

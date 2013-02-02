package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.arm.Arm;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandEncapsulator;
import net.sf.laja.cdd.behaviour.hand.HandList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test list operations.
 */
public class ListTest {

    private AreaBrowList createBrowList() {
        TestBrowList list = TestBrow.createList(
                TestBrow.area(1),
                TestBrow.area(2),
                TestBrow.area(3)).asTestBrowList();

        return new AreaBrowList(list);
    }

    @Test
    public void remove_createdFromVarargConstructor() {
        AreaBrowList list = createBrowList();

        list.remove(1);

        assertEquals(Arrays.asList(1, 3), list.areas());
    }

    private TestBrowEncapsulator area(int area) {
        return TestBrow.area(area);
    }

    private TestBrow brow(int area) {
        return area(area).asTestBrow();
    }

    @Test
    public void remove_createdFromList() {
        List<TestBrow> brows = new ArrayList<TestBrow>();
        brows.add(brow(1));
        brows.add(brow(2));
        brows.add(brow(3));

        AreaBrowList list = new AreaBrowList(brows);

        list.remove(1);

        assertEquals(Arrays.asList(1, 3), list.areas());
    }

    @Test
    public void remove_createdFromStateList() {
        TestForehead forehead = TestForehead.create().withBrows(Brow.area(1), Brow.area(2), Brow.area(3)).asTestForehead();

        AreaBrowList list = new AreaBrowList(forehead.removeBrow(1));

        TestBrowList expectedList = TestBrow.createList(area(1),area(3)).asTestBrowList();

        assertEquals(expectedList, list);
        assertEquals(Arrays.asList(1, 3), list.areas());
    }

    @Test
    public void size() {
        assertEquals(3, createBrowList().size());
    }

    @Test
    public void isEmpty() {
        assertTrue(new TestBrowArrayList().isEmpty());
    }

    @Test
    public void isEmpty_false() {
        assertFalse(createBrowList().isEmpty());
    }

    @Test
    public void contains() {
        assertTrue(createBrowList().contains(brow(2)));
    }

    @Test
    public void contains_not() {
        assertFalse(createBrowList().contains(brow(4)));
    }

    @Test
    public void iterator() {
        Iterator<TestBrow> iterator = createBrowList().iterator();
        assertEquals(brow(1), iterator.next());
    }

    @Test
    public void containsAll() {
        AreaBrowList list = createBrowList();
        AreaBrowList collection = new AreaBrowList(brow(2), brow(3));
        assertTrue(list.containsAll(collection));
    }

    @Test
    public void get() {
        AreaBrowList list = createBrowList();
        assertEquals(brow(2), list.get(1));
        assertEquals(new Integer(2), list.areas().get(1));
    }

    private HandEncapsulator hand(int area) {
        return Hand.area(area);
    }

    @Test
    public void add() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1)).asArm();
        arm1.getHands().add(hand(2).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(2)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void addAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2)).asArm();
        arm1.getHands().add(1, hand(3).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(3), hand(2)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void addAll() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2)).asArm();
        arm1.getHands().addAll(Hand.createList(hand(3), hand(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(2), hand(3), hand(4)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void addAllAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2)).asArm();
        arm1.getHands().addAll(1, Hand.createList(hand(3), hand(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(3), hand(4), hand(2)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void remove() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3)).asArm();
        arm1.removeHand(hand(2).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void removeAll() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3), hand(4), hand(5)).asArm();
        arm1.getHands().removeAll(Hand.createList(hand(3), hand(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(2), hand(5)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void retainAll() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3)).asArm();
        arm1.getHands().retainAll(Hand.createList(hand(2), hand(3), hand(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(2), hand(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void clear() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3)).asArm();
        arm1.getHands().clear();
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList().asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void set() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3)).asArm();
        arm1.getHands().set(1, hand(4).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(4), hand(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
        public void removeAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(hand(1), hand(2), hand(3)).asArm();
        arm1.getHands().remove(1);
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(hand(1), hand(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    public void sort() {
        Arm arm1 = Arm.armWeight(10).hands(hand(3), hand(2), hand(1)).asArm();
        HandList hands = arm1.getHands();

        Collections.sort(hands);

        Arm arm2 = arm1.asArm();
        HandList expectedList = Hand.createList(hand(1), hand(2), hand(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }
}

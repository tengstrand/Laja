package net.sf.laja.cdd.behaviour;

import junit.framework.Assert;
import net.sf.laja.cdd.behaviour.arm.Arm;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.foot.Foot;
import net.sf.laja.cdd.behaviour.hair.FakeHairList;
import net.sf.laja.cdd.behaviour.hair.Hair;
import net.sf.laja.cdd.behaviour.hair.HairList;
import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.toe.Toe;
import net.sf.laja.cdd.behaviour.toe.ValToeList;
import org.junit.Ignore;
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

        assertEquals(Arrays.asList(1, 3), list.areas());
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
        TestForehead forehead = TestForehead.create().withBrows(Brow.createList(Brow.area(1), Brow.area(2), Brow.area(3))).asTestForehead();

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
    public void containsAll() {
        TestBrowList list = createBrowList();
        TestBrowList collection = new TestBrowList(
                TestBrow.area(2).asTestBrow(),
                TestBrow.area(3).asTestBrow()
        );
        assertTrue(list.containsAll(collection));
    }

    @Test
    public void get() {
        TestBrowList list = createBrowList();
        TestBrow expectedBrow = TestBrow.area(2).asTestBrow();

        assertEquals(expectedBrow, list.get(1));
        assertEquals(new Integer(2), list.areas().get(1));
    }

    private TestMouthList createTestMouthList() {
        return TestMouthFactory.createList(TestMouth.width(10).height(5).color("Red"),
                TestMouth.width(8).height(4).color("Blue")).asTestMouthList();
    }

    @Test
    public void tryRemoveElementViaValueBasedListHavingEntityBasedState() {
        final int length = 9;
        final String red = "Red";
        final String black = "Black";
        final String blond = "Blond";

        HairList hairList = Hair.createList(
                Hair.length(length).color(red),
                Hair.length(length).color(black),
                Hair.length(length).color(blond)
        ).asHairList();

        HairList expectedHair = Hair.createList(
                Hair.length(length).color(black),
                Hair.length(length).color(blond)
        ).asHairList();

        // Will remove the Red hair.
        hairList.remove(Hair.length(length).color(black).asHair());

        assertEquals(2, hairList.size());
        assertTrue(hairList.containsAll(expectedHair));

        FakeHairList fakeList = hairList.asFakeHairList();

        assertEquals(2, fakeList.size());

        System.out.println(fakeList);

        fakeList.remove(Hair.length(length).color(blond).asFakeHair());

        assertEquals(1, fakeList.size());
        assertTrue(fakeList.get(0).hasColor(black));
    }

    @Test
    public void add() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1))).asArm();
        arm1.hands.add(Hand.area(2).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(2)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void addAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2))).asArm();
        arm1.hands.add(1, Hand.area(3).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(3), Hand.area(2)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void addAll() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2))).asArm();
        arm1.hands.addAll(Hand.createList(Hand.area(3), Hand.area(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3), Hand.area(4)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void addAllAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2))).asArm();
        arm1.hands.addAll(1, Hand.createList(Hand.area(3), Hand.area(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(3), Hand.area(4), Hand.area(2)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void remove() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3))).asArm();
        arm1.hands.remove(Hand.area(2).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(3)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void removeAll() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3), Hand.area(4), Hand.area(5))).asArm();
        arm1.hands.removeAll(Hand.createList(Hand.area(3), Hand.area(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(2), Hand.area(5)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void retainAll() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3))).asArm();
        arm1.hands.retainAll(Hand.createList(Hand.area(2), Hand.area(3), Hand.area(4)).asHandList());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(2), Hand.area(3)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void clear() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3))).asArm();
        arm1.hands.clear();
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList().asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void set() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3))).asArm();
        arm1.hands.set(1, Hand.area(4).asHand());
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(4), Hand.area(3)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void removeAtIndex() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3))).asArm();
        arm1.hands.remove(1);
        Arm arm2 = arm1.asArm();

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(3)).asHandList();

        assertEquals(expectedList, arm1.hands);
        assertEquals(expectedList, arm2.hands);
    }

    @Test
    public void sort() {
        Arm arm1 = Arm.armWeight(10).hands(Hand.createList(Hand.area(3), Hand.area(2), Hand.area(1))).asArm();
        HandList hands = arm1.hands;
        Arm arm2 = arm1.asArm();

        Collections.sort(hands);

        HandList expectedList = Hand.createList(Hand.area(1), Hand.area(2), Hand.area(3)).asHandList();

        assertEquals(expectedList, arm1.getHands());
        assertEquals(expectedList, arm2.getHands());
    }

    @Test
    @Ignore
    public void removeValueFromEntityStateList() {
        Foot foot = Foot.area(10).toes(Toe.createList(Toe.length(1).weight(1), Toe.length(1).weight(2))).asFoot();
        ValToeList valToes = foot.toes.asValToeList();
        valToes.remove(Toe.length(1).weight(2).asToe());

        //ToeList expectedList = Hand.createList(Hand.area(1), Hand.area(3)).asHandList();

        assertEquals(Toe.createList(Toe.length(1).weight(1)).asValToeList(), valToes);
        assertEquals(Toe.createList(Toe.length(1).weight(1)).asValToeList(), foot.toes.asValToeList());

        System.out.println(valToes);
        System.out.println(foot.toes);
    }
}

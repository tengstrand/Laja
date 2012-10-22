package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.eye.EyeList;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEyeList;

public class Main {

    public static void main(String... args) {
        BrowList list1 = Brow.createList(Brow.area(1), Brow.area(2), Brow.area(3)).asBrowList();
        BrowList list2 = Brow.createList(Brow.area(11), Brow.area(12), Brow.area(13)).asBrowList();

        BrowList list3 = Brow.createList().asBrowList();
        list3.addAll(list1);

        list3.remove(1);

        System.out.println(list3);

        ScaryEyeList eyes = Eye.createList(Eye.eyeWeightInGrams(1).color(1)).asEyeList().asScaryEyeList();
    }
}

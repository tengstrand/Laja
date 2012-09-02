package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.BrowStateList;

import java.util.List;

public class BrowList extends BrowAbstractList {
    public BrowList(Brow... list) {
        super(list);
    }

    public BrowList(List<Brow> list) {
        super(list);
    }

    public BrowList(BrowStateList stateList) {
        super(stateList);
    }

    public static void main(String... args) {
        BrowList browList = Brow.createList(Brow.area(1), Brow.area(2)).asBrowList();
        browList.add(Brow.area(3).asBrow());
        System.out.println("BrowList = " + browList);

        browList.remove(0);
    }
}

package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.behaviour.mouth.CuteMouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthFactory;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.behaviour.mouth.MouthSize.SMALL;
import static org.junit.Assert.assertEquals;

public class IdentityTest {

    @Test (expected = UnsupportedOperationException.class)
    public void removeValueFromEntityStateList() {
        final int width = 10;
        final int height = 5;
        final String red = "Red";
        final String green = "Green";

        CuteMouthList cuteMouthList = MouthFactory.createList(MouthFactory.width(width).height(height).color(red),
                MouthFactory.width(width).height(height).color(green)).asMouthList(SMALL).asCuteMouthList(SMALL, 1);

        CuteMouth greenMouth = cuteMouthList.get(1);

        cuteMouthList.remove(greenMouth);

        System.out.println(cuteMouthList);

        cuteMouthList.doSomething();

        assertEquals(1, cuteMouthList.size());
        assertTrue(cuteMouthList.get(0).hasColor("Red"));
    }
}

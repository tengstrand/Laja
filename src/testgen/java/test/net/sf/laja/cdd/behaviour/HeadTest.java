package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.forehead.Forehead;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.behaviour.mouth.MouthFactory;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.behaviour.nose.Nose;
import net.sf.laja.cdd.behaviour.nose.NoseListEncapsulator;
import org.junit.Test;

public class HeadTest {

    @Test
    public void test() {
        MouthList mouths = MouthFactory.createList(MouthFactory.width(10).height(5).color("red"), MouthFactory.width(15).height(5).color("blue")).asMouthList(MouthSize.SMALL);

        NoseListEncapsulator noses = Nose.createList(Nose.noseDescription("sd").details(""));
        Head head = Head
                .headWeightInGrams(200)
                .leftEye(Eye.eyeWeightInGrams(50).color("1"))
                .rightEye(Eye.eyeWeightInGrams(51).color("2"))
                .noses(noses)
                .forehead(Forehead.create())
                .a(true).b((byte) 1).c((short) 2).d('a').e(3).f(4).g((float) 5.0).h(6.0)
                .mouths(MouthFactory.width(10).height(5).color("red")).asHead();

        System.out.println(head);
    }

    Forehead forehead = Forehead.create().withBrows(Brow.area(200)).asForehead();
}

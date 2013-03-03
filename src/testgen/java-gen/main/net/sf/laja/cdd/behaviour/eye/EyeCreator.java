package net.sf.laja.cdd.behaviour.eye;
import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;

public class EyeCreator {
    private final EyeStateBuilder builder = EyeStateImpl.build();

    public class EyeWeightInGrams_ {
        public Color_ eyeWeightInGrams(int eyeWeightInGrams) {
            builder.withEyeWeightInGrams(eyeWeightInGrams);
            return new Color_();
        }
    }

    public class Color_ {
        public EyeEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public EyeEncapsulator create() {
        return new EyeEncapsulator(builder);
     }
}

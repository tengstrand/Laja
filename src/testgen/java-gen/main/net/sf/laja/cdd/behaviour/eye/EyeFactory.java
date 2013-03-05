package net.sf.laja.cdd.behaviour.eye;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.cdd.state.eye.*;

public class EyeFactory extends EyeBehaviour {

    public EyeFactory(EyeState state) {
        super(state);
    }

    public static EyeCreator.Color_ eyeWeightInGrams(int eyeWeightInGrams) {
        return new EyeCreator().new EyeWeightInGrams_().eyeWeightInGrams(eyeWeightInGrams);
    }

    public static EyeBuilder build() {
        return new EyeBuilder();
    }

    public static EyeSetEncapsulator createSet(EyeEncapsulator... encapsulators) {
        return new EyeSetEncapsulator(encapsulators);
    }

    public static EyeListEncapsulator createList(EyeEncapsulator... encapsulators) {
        return new EyeListEncapsulator(encapsulators);
    }

    public static class EyeFactory_ implements EyeBehaviourFactory {

        public Object create(EyeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Eye'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(EyeState state, Object... args) {
        return new Eye(state);
    
      }
    }
}

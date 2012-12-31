package net.sf.laja.cdd.state.eye;

import java.math.BigDecimal;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface EyeState {
    int getEyeWeightInGrams();
    void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator);

    String getColor();
    void setColor(String color, Object mutator);

    String getDecease(); // (hide)
    void setDecease(String decease, Object mutator);

    Boolean getHasEar(); // (optional)
    void setHasEar(Boolean hasEar, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}

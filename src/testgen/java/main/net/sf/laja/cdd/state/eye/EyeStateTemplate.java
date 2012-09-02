package net.sf.laja.cdd.state.eye;

import java.math.BigDecimal;

public class EyeStateTemplate {
    int eyeWeightInGrams;
    String color;
    String decease; // (hide)
    Boolean hasEar; // (optional)

    int convertWeight(String eyeWeightInGrams) {
        return Integer.valueOf(eyeWeightInGrams);
    }

    String convertColor(BigDecimal color) {
        return color.toString();
    }

    String convertColor(int color) {
        return String.valueOf(color);
    }

    String convertDecease(int decease) {
        return String.valueOf(decease);
    }
}

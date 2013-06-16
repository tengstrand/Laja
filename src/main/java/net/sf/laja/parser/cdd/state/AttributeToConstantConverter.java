package net.sf.laja.parser.cdd.state;

public class AttributeToConstantConverter {

    public String toConstant(String text) {
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += "_" + c;
            } else {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }
}

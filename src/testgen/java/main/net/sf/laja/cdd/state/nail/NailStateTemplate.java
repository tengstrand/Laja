package net.sf.laja.cdd.state.nail;

public class NailStateTemplate {
    String color;

    public boolean isValid() {
        return "red".equals(color);
    }
}

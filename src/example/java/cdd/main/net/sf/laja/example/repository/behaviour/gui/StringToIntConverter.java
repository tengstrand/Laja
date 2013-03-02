package net.sf.laja.example.repository.behaviour.gui;

public class StringToIntConverter {
    private final String value;

    public StringToIntConverter(int value) {
        this.value = String.valueOf(value);
    }
    
    public StringToIntConverter(String value) {
        this.value = value;
    }

    public boolean isValid() {
        if (value == null) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public int value() {
        return Integer.parseInt(value);
    }

    public String stringValue() {
        return value;
    }
}

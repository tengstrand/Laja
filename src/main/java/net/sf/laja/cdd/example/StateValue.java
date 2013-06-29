package net.sf.laja.cdd.example;

public interface StateValue {
    void validate(String attributeName, Object rootElement, String parent, ValidationErrors.Builder errors);
}

package net.sf.laja.cdd.testgen;

public interface StateValue {
    void validate(String attributeName, Object rootElement, String parent, ValidationErrors.Builder errors);
}

package net.sf.laja.cdd.state;

import net.sf.laja.cdd.StateValue;
import net.sf.laja.cdd.ValidationErrors;

public class HairColorStateValue implements StateValue {
    public final int id;

    public HairColorStateValue(int id) {
        this.id = id;
    }

    public void validate(String attributeName, Object rootElement, String parent, ValidationErrors.Builder errors) {
        if (id < 0 || id > 4) {
            errors.addError(rootElement, parent, attributeName, "Unknown hair color id: " + id);
        }
    }
}

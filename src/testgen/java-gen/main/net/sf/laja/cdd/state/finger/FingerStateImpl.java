package net.sf.laja.cdd.state.finger;

import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.nail.NailStateImpl;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.nail.NailStateImpl;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class FingerStateImpl implements FingerState {
    protected String color;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public NailState getNailState() {
        return new NailState() {
            public Certificate certificate() { return certificate(); }

            public String getColor() { return FingerStateImpl.this.getColor(); }
            public void setColor(String color, Object mutator) { FingerStateImpl.this.setColor(color, mutator); }

            public void encapsulate() { FingerStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { FingerStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                if (color == null) {
                    return false;
                }
        if (!isNailValid()) {
            return false;
        }
                return "red".equals(color);
            }

    private boolean isNailValid() {
        return "red".equals(color);
    }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof FingerStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                NailStateImpl state = (NailStateImpl)value;

                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = color != null ? color.hashCode() : 0;

                return result;
            }

            @Override
            public String toString() {
                return "{color=" + color + "}";
            }
        };
    }

    FingerStateImpl() {
    }

    public FingerStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static FingerStateBuilder build() {
        return new FingerStateBuilderImpl();
    }

    public static FingerStateBuilder build(FingerState state) {
        return new FingerStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (color == null) {
            return false;
        }
        if (!isNailValid()) {
            return false;
        }
        return true;
    }

    private boolean isNailValid() {
        return "red".equals(color);
    }

    // Getters
    public String getColor() { return color; }

    // Setters
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by current instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }


    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof FingerStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        FingerStateImpl state = (FingerStateImpl)value;

        if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;

        return result;
    }

    @Override
    public String toString() {
        return "{color=" + color + "}";
    }
}

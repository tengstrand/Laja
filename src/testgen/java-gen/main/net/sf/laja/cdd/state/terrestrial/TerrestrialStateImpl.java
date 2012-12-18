package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.eye.EyeState;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TerrestrialStateImpl implements TerrestrialState {
    protected int numberOfLegs;
    protected int numberOfWings; // (hide)
    protected EyeState leftEye;
    protected EyeState rightEye; // (hide)
    protected EyeState middleEye; // (optional)
    protected int weight; // (hide)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    TerrestrialStateImpl() {
    }

    public TerrestrialStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static TerrestrialStateBuilder build() {
        return new TerrestrialStateBuilderImpl();
    }

    public static TerrestrialStateBuilder build(TerrestrialState state) {
        return new TerrestrialStateBuilderImpl(state);
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
        if ((leftEye == null || !leftEye.isValid())
           || (encapsulated && (rightEye == null || !rightEye.isValid()))
           || (middleEye != null && !middleEye.isValid())) {
            return false;
        }
        return true;
    }

    // Getters
    public int getNumberOfLegs() { return numberOfLegs; }
    public int getNumberOfWings() { return numberOfWings; }
    public EyeState getLeftEye() { return leftEye; }
    public EyeState getRightEye() { return rightEye; }
    public EyeState getMiddleEye() { return middleEye; }
    public int getWeight() { return weight; }

    // Setters
    public void setNumberOfLegs(int numberOfLegs, Object mutator) { checkMutator(mutator); this.numberOfLegs = numberOfLegs; }
    public void setNumberOfWings(int numberOfWings, Object mutator) { checkMutator(mutator); this.numberOfWings = numberOfWings; }
    public void setLeftEye(EyeState leftEye, Object mutator) { checkMutator(mutator); this.leftEye = leftEye; }
    public void setRightEye(EyeState rightEye, Object mutator) { checkMutator(mutator); this.rightEye = rightEye; }
    public void setMiddleEye(EyeState middleEye, Object mutator) { checkMutator(mutator); this.middleEye = middleEye; }
    public void setWeight(int weight, Object mutator) { checkMutator(mutator); this.weight = weight; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }


    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerrestrialStateImpl state = (TerrestrialStateImpl)o;

        if (numberOfLegs != state.getNumberOfLegs()) return false;
        if (numberOfWings != state.getNumberOfWings()) return false;
        if (leftEye != null ? !leftEye.equals(state.leftEye) : state.leftEye != null) return false;
        if (rightEye != null ? !rightEye.equals(state.rightEye) : state.rightEye != null) return false;
        if (middleEye != null ? !middleEye.equals(state.middleEye) : state.middleEye != null) return false;
        if (weight != state.getWeight()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerrestrialStateImpl state = (TerrestrialStateImpl)o;

        if (numberOfLegs != state.getNumberOfLegs()) return false;
        if (numberOfWings != state.getNumberOfWings()) return false;
        if (leftEye != null ? !leftEye.equals(state.leftEye) : state.leftEye != null) return false;
        if (rightEye != null ? !rightEye.equals(state.rightEye) : state.rightEye != null) return false;
        if (middleEye != null ? !middleEye.equals(state.middleEye) : state.middleEye != null) return false;
        if (weight != state.getWeight()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfLegs;
        result = 31 * result + numberOfWings;
        result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
        result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
        result = 31 * result + (middleEye != null ? middleEye.hashCode() : 0);
        result = 31 * result + weight;

        return result;
    }

    public int valueHashCode() {
        int result = numberOfLegs;
        result = 31 * result + numberOfWings;
        result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
        result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
        result = 31 * result + (middleEye != null ? middleEye.hashCode() : 0);
        result = 31 * result + weight;

        return result;
    }

    @Override
    public String toString() {
        return "{numberOfLegs=" + numberOfLegs +
                ", numberOfWings=" + numberOfWings +
                ", leftEye=" + leftEye +
                ", rightEye=" + rightEye +
                ", middleEye=" + middleEye +
                ", weight=" + weight + "}";
    }
}

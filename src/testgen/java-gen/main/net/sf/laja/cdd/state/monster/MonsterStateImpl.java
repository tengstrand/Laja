package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.nose.NoseStateArrayList;
import net.sf.laja.cdd.state.brow.BrowStateArrayList;
import net.sf.laja.cdd.state.ear.EarStateArrayList;
import net.sf.laja.cdd.state.mouth.MouthStateArrayList;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class MonsterStateImpl implements MonsterState {
    protected int numberOfLegs;
    protected int numberOfOwnWings;
    protected double headWeightInGrams;
    protected EyeState leftEye;
    protected EyeState rightEye;
    protected EyeState midEye; // (optional)
    protected int eyeWeightInGrams;
    protected String color;
    protected String decease; // (hide)
    protected NoseStateList noses;
    protected BrowStateList brows; // (optional)
    protected int length; // (optional)
    protected boolean a;
    protected byte b;
    protected short c;
    protected char d;
    protected int e; // (hidden)
    protected long f;
    protected float g;
    protected double h;
    protected EarStateList ears; // (optional)
    protected MouthStateList mouths;
    protected int weight;
    protected Boolean hasEar;
    protected double headWeight;
    protected ArmState leftArm;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public EyeState getEyeState() {
        return new EyeState() {
            public Certificate certificate() { return certificate(); }
            public int getEyeWeightInGrams() { return MonsterStateImpl.this.weight; }
            public void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator) { MonsterStateImpl.this.setWeight(eyeWeightInGrams, mutator); }

            public String getColor() { return MonsterStateImpl.this.color; }
            public void setColor(String color, Object mutator) { MonsterStateImpl.this.setColor(color, mutator); }

            public String getDecease() { return MonsterStateImpl.this.decease; }
            public void setDecease(String decease, Object mutator) { MonsterStateImpl.this.setDecease(decease, mutator); }

            public Boolean getHasEar() { return MonsterStateImpl.this.hasEar; }
            public void setHasEar(Boolean hasEar, Object mutator) { MonsterStateImpl.this.setHasEar(hasEar, mutator); }

            public void encapsulate() { MonsterStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { MonsterStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                if (getColor() == null
           || (encapsulated && getDecease() == null)) {
                    return false;
                }
        if (!isHeadValid()) {
            return false;
        }
                return true;
            }

    private boolean isHeadValid() {
        return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;
    }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                net.sf.laja.cdd.state.eye.EyeState state = (net.sf.laja.cdd.state.eye.EyeState)obj;

                if (weight != state.getEyeWeightInGrams()) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;
                if (decease != null ? !decease.equals(state.getDecease()) : state.getDecease() != null) return false;
                if (hasEar != null ? !hasEar.equals(state.getHasEar()) : state.getHasEar() != null) return false;

                return true;
            }

            public boolean equalsValue(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                net.sf.laja.cdd.state.eye.EyeState state = (net.sf.laja.cdd.state.eye.EyeState)obj;

                if (weight != state.getEyeWeightInGrams()) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;
                if (decease != null ? !decease.equals(state.getDecease()) : state.getDecease() != null) return false;
                if (hasEar != null ? !hasEar.equals(state.getHasEar()) : state.getHasEar() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = weight;
                result = 31 * result + (color != null ? color.hashCode() : 0);
                result = 31 * result + (decease != null ? decease.hashCode() : 0);
                result = 31 * result + (hasEar != null ? hasEar.hashCode() : 0);

                return result;
            }

            @Override
            public String toString() {
                return "{eyeWeightInGrams=" + getEyeWeightInGrams() +
                        ", color=" + (getColor() == null ? null : '\'' + getColor() + '\'' ) +
                        ", decease=" + (getDecease() == null ? null : '\'' + getDecease() + '\'' ) +
                        ", hasEar=" + getHasEar() + "}";
            }
        };
    }

    public TerrestrialState getTerrestrialState() {
        return new TerrestrialState() {
            public Certificate certificate() { return certificate(); }
            public int getNumberOfLegs() { return MonsterStateImpl.this.numberOfLegs; }
            public void setNumberOfLegs(int numberOfLegs, Object mutator) { MonsterStateImpl.this.setNumberOfLegs(numberOfLegs, mutator); }

            public int getNumberOfWings() { return MonsterStateImpl.this.numberOfOwnWings; }
            public void setNumberOfWings(int numberOfWings, Object mutator) { MonsterStateImpl.this.setNumberOfOwnWings(numberOfWings, mutator); }

            public EyeState getLeftEye() { return MonsterStateImpl.this.leftEye; }
            public void setLeftEye(EyeState leftEye, Object mutator) { MonsterStateImpl.this.setLeftEye(leftEye, mutator); }

            public EyeState getRightEye() { return MonsterStateImpl.this.rightEye; }
            public void setRightEye(EyeState rightEye, Object mutator) { MonsterStateImpl.this.setRightEye(rightEye, mutator); }

            public EyeState getMiddleEye() { return MonsterStateImpl.this.midEye; }
            public void setMiddleEye(EyeState middleEye, Object mutator) { MonsterStateImpl.this.setMidEye(middleEye, mutator); }

            public int getWeight() { return MonsterStateImpl.this.weight; }
            public void setWeight(int weight, Object mutator) { MonsterStateImpl.this.setWeight(weight, mutator); }

            public void encapsulate() { MonsterStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { MonsterStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                if ((getLeftEye() == null || !getLeftEye().isValid())
           || (encapsulated && (getRightEye() == null || !getRightEye().isValid()))
           || (getMiddleEye() != null && !getMiddleEye().isValid())) {
                    return false;
                }
        if (!isHeadValid()) {
            return false;
        }
                return true;
            }

    private boolean isHeadValid() {
        return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;
    }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                net.sf.laja.cdd.state.terrestrial.TerrestrialState state = (net.sf.laja.cdd.state.terrestrial.TerrestrialState)obj;

                if (numberOfLegs != state.getNumberOfLegs()) return false;
                if (numberOfOwnWings != state.getNumberOfWings()) return false;
                if (leftEye != null ? !leftEye.equals(state.getLeftEye()) : state.getLeftEye() != null) return false;
                if (rightEye != null ? !rightEye.equals(state.getRightEye()) : state.getRightEye() != null) return false;
                if (midEye != null ? !midEye.equals(state.getMiddleEye()) : state.getMiddleEye() != null) return false;
                if (weight != state.getWeight()) return false;

                return true;
            }

            public boolean equalsValue(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                net.sf.laja.cdd.state.terrestrial.TerrestrialState state = (net.sf.laja.cdd.state.terrestrial.TerrestrialState)obj;

                if (numberOfLegs != state.getNumberOfLegs()) return false;
                if (numberOfOwnWings != state.getNumberOfWings()) return false;
                if (leftEye != null ? !leftEye.equals(state.getLeftEye()) : state.getLeftEye() != null) return false;
                if (rightEye != null ? !rightEye.equals(state.getRightEye()) : state.getRightEye() != null) return false;
                if (midEye != null ? !midEye.equals(state.getMiddleEye()) : state.getMiddleEye() != null) return false;
                if (weight != state.getWeight()) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = numberOfLegs;
                result = 31 * result + numberOfOwnWings;
                result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
                result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
                result = 31 * result + (midEye != null ? midEye.hashCode() : 0);
                result = 31 * result + weight;

                return result;
            }

            @Override
            public String toString() {
                return "{numberOfLegs=" + getNumberOfLegs() +
                        ", numberOfWings=" + getNumberOfWings() +
                        ", leftEye=" + getLeftEye() +
                        ", rightEye=" + getRightEye() +
                        ", middleEye=" + getMiddleEye() +
                        ", weight=" + getWeight() + "}";
            }
        };
    }

    MonsterStateImpl() {
        noses = NoseStateArrayList.emptyList();
        brows = BrowStateArrayList.emptyList();
        ears = EarStateArrayList.emptyList();
        mouths = MouthStateArrayList.emptyList();
    }

    public MonsterStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static MonsterStateBuilder build() {
        return new MonsterStateBuilderImpl();
    }

    public static MonsterStateBuilder build(MonsterState state) {
        return new MonsterStateBuilderImpl(state);
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
           || (rightEye == null || !rightEye.isValid())
           || (midEye != null && !midEye.isValid())
           || color == null
           || (encapsulated && decease == null)
           || (noses == null || !noses.isValid())
           || (brows != null && !brows.isValid())
           || (ears != null && !ears.isValid())
           || (mouths == null || !mouths.isValid())
           || hasEar == null
           || (leftArm == null || !leftArm.isValid())) {
            return false;
        }
        if (!isHeadValid()) {
            return false;
        }
        return true;
    }

    private boolean isHeadValid() {
        return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;
    }

    // Getters
    public int getNumberOfLegs() { return numberOfLegs; }
    public int getNumberOfOwnWings() { return numberOfOwnWings; }
    public double getHeadWeightInGrams() { return headWeightInGrams; }
    public EyeState getLeftEye() { return leftEye; }
    public EyeState getRightEye() { return rightEye; }
    public EyeState getMidEye() { return midEye; }
    public int getEyeWeightInGrams() { return eyeWeightInGrams; }
    public String getColor() { return color; }
    public String getDecease() { return decease; }
    public NoseStateList getNoses() { return noses; }
    public BrowStateList getBrows() { return brows; }
    public int getLength() { return length; }
    public boolean getA() { return a; }
    public byte getB() { return b; }
    public short getC() { return c; }
    public char getD() { return d; }
    public int getE() { return e; }
    public long getF() { return f; }
    public float getG() { return g; }
    public double getH() { return h; }
    public EarStateList getEars() { return ears; }
    public MouthStateList getMouths() { return mouths; }
    public int getWeight() { return weight; }
    public Boolean getHasEar() { return hasEar; }
    public double getHeadWeight() { return headWeight; }
    public ArmState getLeftArm() { return leftArm; }

    // Setters
    public void setNumberOfLegs(int numberOfLegs, Object mutator) { checkMutator(mutator); this.numberOfLegs = numberOfLegs; }
    public void setNumberOfOwnWings(int numberOfOwnWings, Object mutator) { checkMutator(mutator); this.numberOfOwnWings = numberOfOwnWings; }
    public void setHeadWeightInGrams(double headWeightInGrams, Object mutator) { checkMutator(mutator); this.headWeightInGrams = headWeightInGrams; }
    public void setLeftEye(EyeState leftEye, Object mutator) { checkMutator(mutator); this.leftEye = leftEye; }
    public void setRightEye(EyeState rightEye, Object mutator) { checkMutator(mutator); this.rightEye = rightEye; }
    public void setMidEye(EyeState midEye, Object mutator) { checkMutator(mutator); this.midEye = midEye; }
    public void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator) { checkMutator(mutator); this.eyeWeightInGrams = eyeWeightInGrams; }
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }
    public void setDecease(String decease, Object mutator) { checkMutator(mutator); this.decease = decease; }
    public void setNoses(NoseStateList noses, Object mutator) { checkMutator(mutator); this.noses.clear(); this.noses.addAll(noses); }
    public void setBrows(BrowStateList brows, Object mutator) { checkMutator(mutator); this.brows.clear(); this.brows.addAll(brows); }
    public void setLength(int length, Object mutator) { checkMutator(mutator); this.length = length; }
    public void setA(boolean a, Object mutator) { checkMutator(mutator); this.a = a; }
    public void setB(byte b, Object mutator) { checkMutator(mutator); this.b = b; }
    public void setC(short c, Object mutator) { checkMutator(mutator); this.c = c; }
    public void setD(char d, Object mutator) { checkMutator(mutator); this.d = d; }
    public void setE(int e, Object mutator) { checkMutator(mutator); this.e = e; }
    public void setF(long f, Object mutator) { checkMutator(mutator); this.f = f; }
    public void setG(float g, Object mutator) { checkMutator(mutator); this.g = g; }
    public void setH(double h, Object mutator) { checkMutator(mutator); this.h = h; }
    public void setEars(EarStateList ears, Object mutator) { checkMutator(mutator); this.ears.clear(); this.ears.addAll(ears); }
    public void setMouths(MouthStateList mouths, Object mutator) { checkMutator(mutator); this.mouths.clear(); this.mouths.addAll(mouths); }
    public void setWeight(int weight, Object mutator) { checkMutator(mutator); this.weight = weight; }
    public void setHasEar(Boolean hasEar, Object mutator) { checkMutator(mutator); this.hasEar = hasEar; }
    public void setHeadWeight(double headWeight, Object mutator) { checkMutator(mutator); this.headWeight = headWeight; }
    public void setLeftArm(ArmState leftArm, Object mutator) { checkMutator(mutator); this.leftArm = leftArm; }

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MonsterStateImpl state = (MonsterStateImpl)obj;

        if (numberOfLegs != state.getNumberOfLegs()) return false;
        if (numberOfOwnWings != state.getNumberOfOwnWings()) return false;
        if (headWeightInGrams != state.getHeadWeightInGrams()) return false;
        if (leftEye != null ? !leftEye.equals(state.leftEye) : state.leftEye != null) return false;
        if (rightEye != null ? !rightEye.equals(state.rightEye) : state.rightEye != null) return false;
        if (midEye != null ? !midEye.equals(state.midEye) : state.midEye != null) return false;
        if (eyeWeightInGrams != state.getEyeWeightInGrams()) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (decease != null ? !decease.equals(state.decease) : state.decease != null) return false;
        if (length != state.getLength()) return false;
        if (a != state.getA()) return false;
        if (b != state.getB()) return false;
        if (c != state.getC()) return false;
        if (d != state.getD()) return false;
        if (e != state.getE()) return false;
        if (f != state.getF()) return false;
        if (g != state.getG()) return false;
        if (h != state.getH()) return false;
        if (weight != state.getWeight()) return false;
        if (hasEar != null ? !hasEar.equals(state.hasEar) : state.hasEar != null) return false;
        if (headWeight != state.getHeadWeight()) return false;
        if (leftArm != null ? !leftArm.equals(state.leftArm) : state.leftArm != null) return false;

        return true;
    }

    public boolean equalsValue(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MonsterStateImpl state = (MonsterStateImpl)obj;

        if (numberOfLegs != state.getNumberOfLegs()) return false;
        if (numberOfOwnWings != state.getNumberOfOwnWings()) return false;
        if (headWeightInGrams != state.getHeadWeightInGrams()) return false;
        if (leftEye != null ? !leftEye.equals(state.leftEye) : state.leftEye != null) return false;
        if (rightEye != null ? !rightEye.equals(state.rightEye) : state.rightEye != null) return false;
        if (midEye != null ? !midEye.equals(state.midEye) : state.midEye != null) return false;
        if (eyeWeightInGrams != state.getEyeWeightInGrams()) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (decease != null ? !decease.equals(state.decease) : state.decease != null) return false;
        if (noses != null ? !noses.equals(state.noses) : state.noses != null) return false;
        if (brows != null ? !brows.equals(state.brows) : state.brows != null) return false;
        if (length != state.getLength()) return false;
        if (a != state.getA()) return false;
        if (b != state.getB()) return false;
        if (c != state.getC()) return false;
        if (d != state.getD()) return false;
        if (e != state.getE()) return false;
        if (f != state.getF()) return false;
        if (g != state.getG()) return false;
        if (h != state.getH()) return false;
        if (ears != null ? !ears.equals(state.ears) : state.ears != null) return false;
        if (mouths != null ? !mouths.equals(state.mouths) : state.mouths != null) return false;
        if (weight != state.getWeight()) return false;
        if (hasEar != null ? !hasEar.equals(state.hasEar) : state.hasEar != null) return false;
        if (headWeight != state.getHeadWeight()) return false;
        if (leftArm != null ? !leftArm.equals(state.leftArm) : state.leftArm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfLegs;
        result = 31 * result + numberOfOwnWings;
        result = 31 * result + (int)headWeightInGrams;
        result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
        result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
        result = 31 * result + (midEye != null ? midEye.hashCode() : 0);
        result = 31 * result + eyeWeightInGrams;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (decease != null ? decease.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (a ? 1 : 0);
        result = 31 * result + b;
        result = 31 * result + c;
        result = 31 * result + d;
        result = 31 * result + e;
        result = (int)(f ^ (f >>> 32));
        result = 31 * result + (int)g;
        result = 31 * result + (int)h;
        result = 31 * result + weight;
        result = 31 * result + (hasEar != null ? hasEar.hashCode() : 0);
        result = 31 * result + (int)headWeight;
        result = 31 * result + (leftArm != null ? leftArm.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{numberOfLegs=" + numberOfLegs +
                ", numberOfOwnWings=" + numberOfOwnWings +
                ", headWeightInGrams=" + headWeightInGrams +
                ", leftEye=" + leftEye +
                ", rightEye=" + rightEye +
                ", midEye=" + midEye +
                ", eyeWeightInGrams=" + eyeWeightInGrams +
                ", color=" + (color == null ? null : '\'' + color + '\'' ) +
                ", decease=" + (decease == null ? null : '\'' + decease + '\'' ) +
                ", noses=" + noses +
                ", brows=" + brows +
                ", length=" + length +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", ears=" + ears +
                ", mouths=" + mouths +
                ", weight=" + weight +
                ", hasEar=" + hasEar +
                ", headWeight=" + headWeight +
                ", leftArm=" + leftArm + "}";
    }
}

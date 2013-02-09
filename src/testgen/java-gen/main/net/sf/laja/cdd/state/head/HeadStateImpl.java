package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.ear.EarStateHashSet;
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
public class HeadStateImpl implements HeadState {
    protected double headWeightInGrams;
    protected EyeState leftEye;
    protected EyeState rightEye;
    protected EyeState midEye; // (optional)
    protected int eyeWeightInGrams;
    protected String color;
    protected String decease; // (hide)
    protected Boolean hasEar; // (optional)
    protected NoseStateList noses;
    protected BrowStateList brows; // (optional)
    protected EarStateSet ears; // (optional)
    protected int length; // (optional)
    protected boolean a;
    protected byte b;
    protected short c;
    protected char d;
    protected int e; // (hidden)
    protected long f;
    protected float g;
    protected double h;
    protected EarStateList optionalEars; // (optional)
    protected MouthStateList mouths;

    private boolean _encapsulated = false;
    private Object _encapsulator;
/*
    public EyeState getEyeState() {
        return new EyeState() {
            public Certificate certificate() { return certificate(); }
            public int getEyeWeightInGrams() { return EyeStateImpl.this.return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;; }
            public void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator) { EyeStateImpl.this.setEyeWeightInGrams(eyeWeightInGrams, mutator); }

            public String getColor() { return EyeStateImpl.this.return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;; }
            public void setColor(String color, Object mutator) { EyeStateImpl.this.setColor(color, mutator); }

            public String getDecease() { return EyeStateImpl.this.return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;; }
            public void setDecease(String decease, Object mutator) { EyeStateImpl.this.setDecease(decease, mutator); }

            public Boolean getHasEar() { return EyeStateImpl.this.return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;; }
            public void setHasEar(Boolean hasEar, Object mutator) { EyeStateImpl.this.setHasEar(hasEar, mutator); }

            public void encapsulate() { HeadStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { HeadStateImpl.this.setEncapsulator(encapsulator); }

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
                return true;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof HeadStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.cdd.state.eye.EyeState state = (net.sf.laja.cdd.state.eye.EyeState)value;

                if (eyeWeightInGrams != state.getEyeWeightInGrams()) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;
                if (decease != null ? !decease.equals(state.getDecease()) : state.getDecease() != null) return false;
                if (hasEar != null ? !hasEar.equals(state.getHasEar()) : state.getHasEar() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = eyeWeightInGrams;
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
*/
/*
    public ForeheadState getForeheadState() {
        return new ForeheadState() {
            public Certificate certificate() { return certificate(); }
            public BrowStateList getBrows() { return ForeheadStateImpl.this.NULL; }
            public void setBrows(BrowStateList brows, Object mutator) { ForeheadStateImpl.this.setBrows(brows, mutator); }

            public EarStateSet getEars() { return ForeheadStateImpl.this.NULL; }
            public void setEars(EarStateSet ears, Object mutator) { ForeheadStateImpl.this.setEars(ears, mutator); }

            public void encapsulate() { HeadStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { HeadStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                return true;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof HeadStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.cdd.state.forehead.ForeheadState state = (net.sf.laja.cdd.state.forehead.ForeheadState)value;

                if (brows != null ? !brows.equals(state.getBrows()) : state.getBrows() != null) return false;
                if (ears != null ? !ears.equals(state.getEars()) : state.getEars() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public String toString() {
                return "{brows=" + getBrows() +
                        ", ears=" + getEars() + "}";
            }
        };
    }
*/

    public EyeState getEyeState() {
        return new EyeState() {
            public Certificate certificate() { return certificate(); }
            public int getEyeWeightInGrams() { return 0; /* missing attribute 'eyeWeightInGrams' */ }
            public void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator) { /* missing attribute 'eyeWeightInGrams' */ }

            public String getColor() { return null; /* missing attribute 'color' */ }
            public void setColor(String color, Object mutator) { /* missing attribute 'color' */ }

            public String getDecease() { return null; /* missing attribute 'decease' */ }
            public void setDecease(String decease, Object mutator) { /* missing attribute 'decease' */ }

            public Boolean getHasEar() { return null; /* missing attribute 'hasEar' */ }
            public void setHasEar(Boolean hasEar, Object mutator) { /* missing attribute 'hasEar' */ }

            public void encapsulate() { HeadStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { HeadStateImpl.this.setEncapsulator(encapsulator); }

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
                return true;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof HeadStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.cdd.state.eye.EyeState state = (net.sf.laja.cdd.state.eye.EyeState)value;

                if (eyeWeightInGrams != state.getEyeWeightInGrams()) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;
                if (decease != null ? !decease.equals(state.getDecease()) : state.getDecease() != null) return false;
                if (hasEar != null ? !hasEar.equals(state.getHasEar()) : state.getHasEar() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = eyeWeightInGrams;
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

    public ForeheadState getForeheadState() {
        return new ForeheadState() {
            public Certificate certificate() { return certificate(); }
            public BrowStateList getBrows() { return null; /* missing attribute 'brows' */ }
            public void setBrows(BrowStateList brows, Object mutator) { /* missing attribute 'brows' */ }

            public EarStateSet getEars() { return null; /* missing attribute 'ears' */ }
            public void setEars(EarStateSet ears, Object mutator) { /* missing attribute 'ears' */ }

            public void encapsulate() { HeadStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { HeadStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                return true;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof HeadStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.cdd.state.forehead.ForeheadState state = (net.sf.laja.cdd.state.forehead.ForeheadState)value;

                if (brows != null ? !brows.equals(state.getBrows()) : state.getBrows() != null) return false;
                if (ears != null ? !ears.equals(state.getEars()) : state.getEars() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public String toString() {
                return "{brows=" + getBrows() +
                        ", ears=" + getEars() + "}";
            }
        };
    }

    HeadStateImpl() {
        ears = EarStateHashSet.emptySet();
    }

    public HeadStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static HeadStateBuilder build() {
        return new HeadStateBuilderImpl();
    }

    public static HeadStateBuilder build(HeadState state) {
        return new HeadStateBuilderImpl(state);
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
           || (optionalEars != null && !optionalEars.isValid())
           || (mouths == null || !mouths.isValid())) {
            return false;
        }
        return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;
    }

    // Getters
    public double getHeadWeightInGrams() { return headWeightInGrams; }
    public EyeState getLeftEye() { return leftEye; }
    public EyeState getRightEye() { return rightEye; }
    public EyeState getMidEye() { return midEye; }
    public int getEyeWeightInGrams() { return eyeWeightInGrams; }
    public String getColor() { return color; }
    public String getDecease() { return decease; }
    public Boolean getHasEar() { return hasEar; }
    public NoseStateList getNoses() { return noses; }
    public BrowStateList getBrows() { return brows; }
    public EarStateSet getEars() { return ears; }
    public int getLength() { return length; }
    public boolean getA() { return a; }
    public byte getB() { return b; }
    public short getC() { return c; }
    public char getD() { return d; }
    public int getE() { return e; }
    public long getF() { return f; }
    public float getG() { return g; }
    public double getH() { return h; }
    public EarStateList getOptionalEars() { return optionalEars; }
    public MouthStateList getMouths() { return mouths; }

    // Setters
    public void setHeadWeightInGrams(double headWeightInGrams, Object mutator) { checkMutator(mutator); this.headWeightInGrams = headWeightInGrams; }
    public void setLeftEye(EyeState leftEye, Object mutator) { checkMutator(mutator); this.leftEye = leftEye; }
    public void setRightEye(EyeState rightEye, Object mutator) { checkMutator(mutator); this.rightEye = rightEye; }
    public void setMidEye(EyeState midEye, Object mutator) { checkMutator(mutator); this.midEye = midEye; }
    public void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator) { checkMutator(mutator); this.eyeWeightInGrams = eyeWeightInGrams; }
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }
    public void setDecease(String decease, Object mutator) { checkMutator(mutator); this.decease = decease; }
    public void setHasEar(Boolean hasEar, Object mutator) { checkMutator(mutator); this.hasEar = hasEar; }
    public void setNoses(NoseStateList noses, Object mutator) { checkMutator(mutator); this.noses.clear(); this.noses.addAll(noses); }
    public void setBrows(BrowStateList brows, Object mutator) { checkMutator(mutator); this.brows.clear(); this.brows.addAll(brows); }
    public void setEars(EarStateSet ears, Object mutator) { checkMutator(mutator); this.ears.clear(); this.ears.addAll(ears); }
    public void setLength(int length, Object mutator) { checkMutator(mutator); this.length = length; }
    public void setA(boolean a, Object mutator) { checkMutator(mutator); this.a = a; }
    public void setB(byte b, Object mutator) { checkMutator(mutator); this.b = b; }
    public void setC(short c, Object mutator) { checkMutator(mutator); this.c = c; }
    public void setD(char d, Object mutator) { checkMutator(mutator); this.d = d; }
    public void setE(int e, Object mutator) { checkMutator(mutator); this.e = e; }
    public void setF(long f, Object mutator) { checkMutator(mutator); this.f = f; }
    public void setG(float g, Object mutator) { checkMutator(mutator); this.g = g; }
    public void setH(double h, Object mutator) { checkMutator(mutator); this.h = h; }
    public void setOptionalEars(EarStateList optionalEars, Object mutator) { checkMutator(mutator); this.optionalEars.clear(); this.optionalEars.addAll(optionalEars); }
    public void setMouths(MouthStateList mouths, Object mutator) { checkMutator(mutator); this.mouths.clear(); this.mouths.addAll(mouths); }

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
       if (!(that instanceof HeadStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        HeadStateImpl state = (HeadStateImpl)value;

        if (headWeightInGrams != state.getHeadWeightInGrams()) return false;
        if (leftEye != null ? !leftEye.equals(state.leftEye) : state.leftEye != null) return false;
        if (rightEye != null ? !rightEye.equals(state.rightEye) : state.rightEye != null) return false;
        if (midEye != null ? !midEye.equals(state.midEye) : state.midEye != null) return false;
        if (eyeWeightInGrams != state.getEyeWeightInGrams()) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (decease != null ? !decease.equals(state.decease) : state.decease != null) return false;
        if (hasEar != null ? !hasEar.equals(state.hasEar) : state.hasEar != null) return false;
        if (noses != null ? !noses.equals(state.noses) : state.noses != null) return false;
        if (brows != null ? !brows.equals(state.brows) : state.brows != null) return false;
        if (ears != null ? !ears.equals(state.ears) : state.ears != null) return false;
        if (length != state.getLength()) return false;
        if (a != state.getA()) return false;
        if (b != state.getB()) return false;
        if (c != state.getC()) return false;
        if (d != state.getD()) return false;
        if (e != state.getE()) return false;
        if (f != state.getF()) return false;
        if (g != state.getG()) return false;
        if (h != state.getH()) return false;
        if (optionalEars != null ? !optionalEars.equals(state.optionalEars) : state.optionalEars != null) return false;
        if (mouths != null ? !mouths.equals(state.mouths) : state.mouths != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)headWeightInGrams;
        result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
        result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
        result = 31 * result + (midEye != null ? midEye.hashCode() : 0);
        result = 31 * result + eyeWeightInGrams;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (decease != null ? decease.hashCode() : 0);
        result = 31 * result + (hasEar != null ? hasEar.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (a ? 1 : 0);
        result = 31 * result + b;
        result = 31 * result + c;
        result = 31 * result + d;
        result = 31 * result + e;
        result = (int)(f ^ (f >>> 32));
        result = 31 * result + (int)g;
        result = 31 * result + (int)h;

        return result;
    }

    @Override
    public String toString() {
        return "{headWeightInGrams=" + headWeightInGrams +
                ", leftEye=" + leftEye +
                ", rightEye=" + rightEye +
                ", midEye=" + midEye +
                ", eyeWeightInGrams=" + eyeWeightInGrams +
                ", color=" + (color == null ? null : '\'' + color + '\'' ) +
                ", decease=" + (decease == null ? null : '\'' + decease + '\'' ) +
                ", hasEar=" + hasEar +
                ", noses=" + noses +
                ", brows=" + brows +
                ", ears=" + ears +
                ", length=" + length +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", optionalEars=" + optionalEars +
                ", mouths=" + mouths + "}";
    }
}

package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateListImpl;
import net.sf.laja.cdd.state.brow.BrowStateListImpl;
import net.sf.laja.cdd.state.ear.EarStateListImpl;
import net.sf.laja.cdd.state.mouth.MouthStateListImpl;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
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

    private boolean _encapsulated = false;

    HeadStateImpl() {
        noses = NoseStateListImpl.emptyList(Certificate.get(this));
        brows = BrowStateListImpl.emptyList(Certificate.get(this));
        ears = EarStateListImpl.emptyList(Certificate.get(this));
        mouths = MouthStateListImpl.emptyList(Certificate.get(this));
    }

    public static HeadStateBuilder build() {
        return new HeadStateBuilderImpl();
    }

    public static HeadStateBuilder build(HeadState state) {
        return new HeadStateBuilderImpl(state);
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

    // Setters
    public void setHeadWeightInGrams(double headWeightInGrams) { this.headWeightInGrams = headWeightInGrams; }
    public void setLeftEye(EyeState leftEye) { this.leftEye = leftEye; }
    public void setRightEye(EyeState rightEye) { this.rightEye = rightEye; }
    public void setMidEye(EyeState midEye) { this.midEye = midEye; }
    public void setEyeWeightInGrams(int eyeWeightInGrams) { this.eyeWeightInGrams = eyeWeightInGrams; }
    public void setColor(String color) { this.color = color; }
    public void setDecease(String decease) { this.decease = decease; }
    public void setHasEar(Boolean hasEar) { this.hasEar = hasEar; }
    public void setNoses(NoseStateList noses) { this.noses.clear(); this.noses.addAll(noses); }
    public void setBrows(BrowStateList brows) { this.brows.clear(); this.brows.addAll(brows); }
    public void setLength(int length) { this.length = length; }
    public void setA(boolean a) { this.a = a; }
    public void setB(byte b) { this.b = b; }
    public void setC(short c) { this.c = c; }
    public void setD(char d) { this.d = d; }
    public void setE(int e) { this.e = e; }
    public void setF(long f) { this.f = f; }
    public void setG(float g) { this.g = g; }
    public void setH(double h) { this.h = h; }
    public void setEars(EarStateList ears) { this.ears.clear(); this.ears.addAll(ears); }
    public void setMouths(MouthStateList mouths) { this.mouths.clear(); this.mouths.addAll(mouths); }

    public void encapsulate() {
        _encapsulated = true;
        leftEye.encapsulate();
        rightEye.encapsulate();
        if (midEye != null) midEye.encapsulate();
        noses.encapsulate();
        if (brows != null) brows.encapsulate();
        if (ears != null) ears.encapsulate();
        mouths.encapsulate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeadStateImpl state = (HeadStateImpl)o;

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

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeadStateImpl state = (HeadStateImpl)o;

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
        result = 31 * result + (noses != null ? noses.hashCode() : 0);
        result = 31 * result + (brows != null ? brows.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (a ? 1 : 0);
        result = 31 * result + b;
        result = 31 * result + c;
        result = 31 * result + d;
        result = 31 * result + e;
        result = 31 * result + (int)f;
        result = 31 * result + (int)g;
        result = 31 * result + (int)h;
        result = 31 * result + (ears != null ? ears.hashCode() : 0);
        result = 31 * result + (mouths != null ? mouths.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = (int)headWeightInGrams;
        result = 31 * result + (leftEye != null ? leftEye.hashCode() : 0);
        result = 31 * result + (rightEye != null ? rightEye.hashCode() : 0);
        result = 31 * result + (midEye != null ? midEye.hashCode() : 0);
        result = 31 * result + eyeWeightInGrams;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (decease != null ? decease.hashCode() : 0);
        result = 31 * result + (hasEar != null ? hasEar.hashCode() : 0);
        result = 31 * result + (noses != null ? noses.hashCode() : 0);
        result = 31 * result + (brows != null ? brows.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (a ? 1 : 0);
        result = 31 * result + b;
        result = 31 * result + c;
        result = 31 * result + d;
        result = 31 * result + e;
        result = 31 * result + (int)f;
        result = 31 * result + (int)g;
        result = 31 * result + (int)h;
        result = 31 * result + (ears != null ? ears.hashCode() : 0);
        result = 31 * result + (mouths != null ? mouths.hashCode() : 0);

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
                ", mouths=" + mouths + "}";
    }
}

package net.sf.laja.cdd.state.mouth;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MouthStateProjection {

    MouthStateProjection() {
    }

    public static MouthStateProjection.Width_ numberOfTeeth(int numberOfTeeth) {
        return new MouthStateProjection().new Width_();
    }

    public class NumberOfTeeth_ {
        public Width_ numberOfTeeth(int numberOfTeeth) {
            return new Width_();
        }
    }

    public class Width_ {
        public Height_ width(int width) {
            return new Height_();
        }
    }

    public class Height_ {
        public Color_ height(int height) {
            return new Color_();
        }
    }

    public class Color_ {
        public MouthStateProjection color(String color) {
            return MouthStateProjection.this;
        }
    }
}

package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;
/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ToeStateProjection {

    ToeStateProjection() {
    }

    public static ToeStateProjection.Weight_ length(int length) {
        return new ToeStateProjection().new Weight_();
    }

    public class Length_ {
        public Weight_ length(int length) {
            return new Weight_();
        }
    }

    public class Weight_ {
        public ToeStateProjection weight(int weight) {
            return ToeStateProjection.this;
        }
    }
}

package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class OwnerStateProjection {

    OwnerStateProjection() {
    }

    public static OwnerStateProjection.Name_ ssn(long ssn) {
        return new OwnerStateProjection().new Name_();
    }

    public class Ssn_ {
        public Name_ ssn(long ssn) {
            return new Name_();
        }
    }

    public class Name_ {
        public OwnerStateProjection name(String name) {
            return OwnerStateProjection.this;
        }
    }
}

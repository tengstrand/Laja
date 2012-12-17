package net.sf.laja.example.repository.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface ZipcodeState {
    int getZipcode();
    void setZipcode(int zipcode);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    Certificate certificate();
}

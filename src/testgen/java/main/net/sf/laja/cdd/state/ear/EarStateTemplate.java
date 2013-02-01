package net.sf.laja.cdd.state.ear;

/**
 * A class with only optional or hidden attributes
 */
public class EarStateTemplate {
    double size; // (hide)
    int weight;

    boolean isValid() {
        return size > 0;
    }
}

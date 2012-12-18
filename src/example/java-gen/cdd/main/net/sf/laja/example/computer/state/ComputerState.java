package net.sf.laja.example.computer.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface ComputerState {
    String getName(); // (hide)
    void setName(String name, Object mutator);

    String getProcessor(); // (hide)
    void setProcessor(String processor, Object mutator);

    int getReleaseYear(); // (hide)
    void setReleaseYear(int releaseYear, Object mutator);

    int getMemoryInKilobytes(); // (hide)
    void setMemoryInKilobytes(int memoryInKilobytes, Object mutator);

    String getOwner();
    void setOwner(String owner, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}

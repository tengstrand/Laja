package net.sf.laja.example.computer.state;

public class ComputerStateTemplate extends ComputerStateImpl {
    String name; // (hide)
    Processor processor; // (hide)
    int releaseYear; // (hide)
    int memoryInKilobytes; // (hide)
    String owner;

    public boolean isValid() {
        return releaseYear > 0 && memoryInKilobytes > 0;
    }
}

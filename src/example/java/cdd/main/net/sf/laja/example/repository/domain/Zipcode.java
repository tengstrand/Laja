package net.sf.laja.example.repository.domain;

public class Zipcode {
    public final int code;

    public Zipcode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return code == ((Zipcode)o).code;
    }

    @Override
    public int hashCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}

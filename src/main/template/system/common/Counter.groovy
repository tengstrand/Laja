
class Counter {
    private int value;

    Counter(int initialValue) {
        value = initialValue
    }

    int get() {
        return value;
    }

    int decrease() {
        value -= 1
        return value + 1
    }

    int increase() {
        value += 1
        return value - 1
    }

    boolean isGreaterThan(int compare) {
        return value > compare;
    }

    @Override String toString() {
        return String.valueOf(value)
    }
}


class Stack {
    private int index = 0
    private stack = new ArrayList()

    void push(Object value) {
        stack.add(index, value);
        index++;
    }

    Object get() {
        if (index == 0) {
            throw new IllegalStateException("The stack is empty")
        }
        return stack.get(index - 1);
    }

    Object pull() {
        if (index == 0) {
            throw new IllegalStateException("The stack is empty")
        }
        index--;
        return stack.get(index);
    }

    @Override String toString() {
        return String.valueOf(stack)
    }
}

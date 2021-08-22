package Week1.Day3.Example2;

import java.io.Serializable;

class Pair<U, V> implements Serializable {
    public final U first;
    public final V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
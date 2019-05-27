package coord.model.figure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Coord {
    private static final int MIN = 0;
    private static final int MAX = 24;

    private static final Map<Integer, Coord> coordPool = new HashMap<>();

    private final int i;

    public static Coord of(int i) {
        if (!coordPool.containsKey(i)) {
            coordPool.put(i, new Coord(i));
        }
        return coordPool.get(i);
    }

    private Coord(int i) {
        if (i < MIN || i > MAX) {
            throw new IllegalArgumentException("좌표의 범위는 "+ MIN + " ~ " + MAX + "입니다.");
        }
        this.i = i;
    }

    public int val() {
        return i;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coord)) {
            return false;
        }
        Coord coord = (Coord) o;
        return i == coord.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
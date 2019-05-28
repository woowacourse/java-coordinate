package coordinatecalculator.model.coordinate;

import java.util.Objects;

public class Coordinate {
    private final Value x;
    private final Value y;

    public Coordinate(int x, int y) {
        this.x = new Value(x);
        this.y = new Value(y);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

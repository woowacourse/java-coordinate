package coordinatecalculator.domain;

import java.util.Objects;

public class Y extends AxisValidator {
    private final int y;

    public Y(final String y) {
        checkNumeric(y);
        checkBoundary(Integer.parseInt(y));

        this.y = Integer.parseInt(y);
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Y y1 = (Y) o;
        return Objects.equals(y, y1.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(y);
    }
}

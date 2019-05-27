package coordinatecalculator.model;

import java.util.Objects;

public class PointValue extends PointProperties {
    private final int pointValue;

    public PointValue(final String pointValue) {
        this.pointValue = validNumber(pointValue);
    }

    @Override
    public int getValue() {
        return pointValue;
    }

    @Override
    public int subtract(int anotherPointValue) {
        return this.pointValue - anotherPointValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointValue that = (PointValue) o;
        return pointValue == that.pointValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointValue);
    }
}

package coordinatecalculator.model;

import java.util.Objects;

public class YPoint extends PointProperties {
    private final int yPoint;

    public YPoint(final String yPoint) {
        this.yPoint = validNumber(yPoint);
    }

    @Override
    public int getValue() {
        return yPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YPoint yPoint1 = (YPoint) o;
        return yPoint == yPoint1.yPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yPoint);
    }
}

package coordinatecalculator.model;

import java.util.Objects;

public class XPoint extends PointProperties {

    private final int xPoint;

    public XPoint(final String xPoint) {
        this.xPoint = validNumber(xPoint);
    }

    @Override
    public int getValue() {
        return xPoint;
    }

    @Override
    public int subtract(int anotherPointValue) {
        return this.xPoint - anotherPointValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XPoint xPoint1 = (XPoint) o;
        return xPoint == xPoint1.xPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint);
    }
}

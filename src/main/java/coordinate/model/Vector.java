package coordinate.model;

import java.util.Objects;

public class Vector {
    private Value xValue;
    private Value yValue;

    Vector(Point firstPoint, Point secondPoint) {
        this.xValue = new Value((int) firstPoint.getXValue().getRateOfChange(secondPoint.getXValue()));
        this.yValue = new Value((int) firstPoint.getYValue().getRateOfChange(secondPoint.getYValue()));
    }

    double getDotProduct(Vector vector) {
        return (this.xValue.getValue() * vector.xValue.getValue())
                + (this.yValue.getValue() * vector.yValue.getValue());
    }

    double getCrossProduct(Vector vector) {
        return this.xValue.getValue() * vector.yValue.getValue()
                + this.yValue.getValue() * vector.xValue.getValue();
    }

    Point sum(Vector vector) {
        return new Point(xValue.sum(vector.xValue), yValue.sum(vector.yValue));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(xValue, vector.xValue) &&
                Objects.equals(yValue, vector.yValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }
}

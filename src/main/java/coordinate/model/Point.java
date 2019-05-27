package coordinate.model;

import java.util.Objects;

public class Point {
    private Value xValue;
    private Value yValue;

    public Point(Value xValue, Value yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public Value getXValue() {
        return xValue;
    }

    public Value getYValue() {
        return yValue;
    }

    double howFar(Point point) {
        double xSquared = this.xValue.rateSquared(point.xValue);
        double ySquared = this.yValue.rateSquared(point.yValue);

        return Math.sqrt(xSquared + ySquared);
    }

    Point move(Vector vector) {
        return new Point(xValue.move(vector.getxDelta()) , yValue.move(vector.getyDelta()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xValue, point.xValue) &&
                Objects.equals(yValue, point.yValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }
}

package coordinate;

import java.util.Objects;

public class Point {
    private Value xValue;
    private Value yValue;

    public Point(Value xValue, Value yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
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

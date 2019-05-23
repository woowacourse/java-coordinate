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

    public double getSlope(Point point){
        double xRate = this.xValue.getRateOfChange(point.xValue);
        double yRate = this.yValue.getRateOfChange(point.yValue);
        double result = yRate/xRate;
        return result;
    }

    public double calculate(Point point) {
        double xSquared = this.xValue.message(point.xValue);
        double ySquared = this.yValue.message(point.yValue);
        return Math.sqrt(xSquared + ySquared);
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

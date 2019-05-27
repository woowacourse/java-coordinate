package coordinatecalculator.model;

import java.util.Objects;

public class Point {
    private Value xVal;
    private Value yVal;

    public Point(String xCoordinate, String yCoordinate) {
        this.xVal = Value.retrieveValue(Integer.parseInt(xCoordinate));
        this.yVal = Value.retrieveValue(Integer.parseInt(yCoordinate));
    }

    public double getSlope(Point point) {
        double xRate = this.xVal.getRateOfChange(point.xVal);
        double yRate = this.yVal.getRateOfChange(point.yVal);
        double result = yRate/ xRate;
        return result;
    }

    public Value getXValue() {
        return xVal;
    }

    public Value getYValue() {
        return yVal;
    }

    public double calculateDistance(Point otherPoint) {
        double xSquared = this.xVal.calculateSquared(otherPoint.xVal);
        double ySquared = this.yVal.calculateSquared(otherPoint.yVal);
        return Math.sqrt(xSquared + ySquared);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xVal, point.xVal) &&
                Objects.equals(yVal, point.yVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xVal, yVal);
    }
}

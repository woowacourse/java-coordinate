package coordinatecalculator.model;

import java.util.Objects;

public class Distance {

    private double distance;

    public Distance(Point previousPoint, Point currentPoint) {
        this.distance = calculateDistance(previousPoint, currentPoint);
    }

    private double calculateDistance(Point previousPoint, Point currentPoint) {
        return Math.sqrt(previousPoint.square(currentPoint));
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return Double.compare(distance1.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}

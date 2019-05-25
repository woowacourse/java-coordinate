package coordinatecalculator.domain;

import java.util.List;

public class PointsManager {
    private final List<Point> points;

    private PointsManager(final List<Point> points) {
        this.points = points;
    }

    public static void createPoints(final List<Point> points) {
        new PointsManager(points);
    }
}

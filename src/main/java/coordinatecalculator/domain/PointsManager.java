package coordinatecalculator.domain;

import java.util.List;

public class PointsManager {
    private List<Point> points;

    private PointsManager(List<Point> points) {
        this.points = points;
    }

    public static void createPoints(List<Point> points) {
        new PointsManager(points);
    }
}

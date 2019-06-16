package location.domain;

import java.util.Collections;
import java.util.List;

public class Points {
    private static final int SQUARE = 2;
    private static List<Point> points;
    private final double MAX = Double.MAX_VALUE;
    private final String POINT_NULL_OR_BLANK_MSG = "포인트가 비어있습니다.";

    public Points(final List<Point> points) {
        checkValid(points);
        compare(points);
        Points.points = Collections.unmodifiableList(points);
    }

    private void checkValid(final List<Point> points) {
        isNullOrBlank(points);
    }

    private void isNullOrBlank(final List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(POINT_NULL_OR_BLANK_MSG);
        }
    }

    private void compare(final List<Point> points) {
        points.sort((p1, p2) -> {
            if (p1.getXCoordinate() == p2.getXCoordinate()) {
                return p1.getyCoordinate() - p2.getyCoordinate();
            }
            return p1.getXCoordinate() - p2.getXCoordinate();
        });
    }

    public double getTwoPointsDistance(int index1, int index2) {
        return Math.sqrt(Math.pow((points.get(index1).getXCoordinate() - points.get(index2).getXCoordinate()), SQUARE)
                + Math.pow((points.get(index1).getyCoordinate() - points.get(index2).getyCoordinate()), SQUARE));
    }

    public double getTwoPointsTilt(int index1, int index2) {
        double denominator = (double) (points.get(index1).getXCoordinate() - points.get(index2).getXCoordinate());
        double molecule = (double) (points.get(index1).getyCoordinate() - points.get(index2).getyCoordinate());
        if (denominator == 0) {
            denominator = MAX;
        }
        return molecule / denominator;
    }

    public Point get(final int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}

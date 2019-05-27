package coordinate.domain;

import java.util.Objects;

public class Line implements ResultPrintable {
    private static final String ERROR_SIZE = "두개의 점이 입력되지 않았습니다.";
    private static final String RESULT_FORMAT = "두 점 사이 거리는 %.6f";
    private static int STANDARD_INDEX = 0;
    private static int LAST_INDEX = 1;
    private static int POINT_SIZE = 2;

    private final Points points;

    private Line(Points points) {
        if (points.getSize() != POINT_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }

        this.points = points;
    }

    public static Line create(Points points) {
        return new Line(points);
    }

    public double calculateDistance() {
        return points.pointsByIndex(STANDARD_INDEX).getDistance(points.pointsByIndex(LAST_INDEX));
    }

    @Override
    public String getResultMessage() {
        return String.format(RESULT_FORMAT, calculateDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

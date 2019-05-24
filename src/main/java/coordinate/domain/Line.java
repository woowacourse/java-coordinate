package coordinate.domain;


public class Line {
    public static final int NUMBER_OF_POINTS = 2;

    private final Points points;

    public Line(Points points) {
        this.points = points;
        validateSize(points);
    }

    private void validateSize(final Points points) {
        if (points.size() != NUMBER_OF_POINTS) {
            throw new IllegalArgumentException("선은 점이 두개 필요합니다.");
        }
    }

    public double length() {
        Point a = points.get(0);
        Point b = points.get(1);
        return a.length(b);
    }

    public Points getPoints() {
        return points;
    }
}

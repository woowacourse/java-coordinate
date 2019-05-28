package coordinate.domain;

public class Line extends Shape {
    private static final int LINE_POINT = 2;

    public Line(final Points points) {
        super(points);
        validate(points);
    }

    private void validate(Points points) {
        if (points.size() != LINE_POINT) {
            throw new IllegalArgumentException("선의 점의 갯수는 2개 입니다.");
        }
    }

    public double getDistance() {
        return getSides().get(0);
    }

    @Override
    public String toString() {
        return "두점 사이의 거리는 " + getDistance();
    }
}

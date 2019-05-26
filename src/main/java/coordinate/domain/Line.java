package coordinate.domain;

public class Line extends Figure {
    private static final int LINE_POINT_SIZE = 2;
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    public Line(Points points) {
        super(points);
        if (points.size() != LINE_POINT_SIZE) {
            throw new IllegalArgumentException("2개의 점으로 구성되어야 합니다");
        }
    }

    public double calculateFigure() {
        return points.get(FIRST_POINT).sub(points.get(SECOND_POINT));
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 ";
    }
}

package coordinate.domain;

public class Line extends Figure {

    public Line(Points points) {
        super(points);
        if (points.size() != 2) {
            throw new IllegalArgumentException("2개의 점으로 구성되어야 합니다");
        }
    }

    public double calculateFigure() {
        return points.get(0).sub(points.get(1));
    }
}

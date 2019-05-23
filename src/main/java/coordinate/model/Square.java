package coordinate.model;

import java.util.List;

public class Square extends Figure {

    public Square(List<Point> points) {
        super(points);
        checkTwist(points);
    }

    private void checkTwist(List<Point> points) {
        if (!points.get(0).isEqualX(points.get(1)) ||
                !points.get(0).isEqualY(points.get(2)) ||
                !points.get(3).isEqualX(points.get(2)) ||
                !points.get(3).isEqualY(points.get(1))) {
            throw new IllegalArgumentException("올바른 사각형이 아닙니다");
        }
    }

    @Override
    public double getScore() {
        return (points.get(0).getDistance(points.get(1))
                * points.get(0).getDistance(points.get(2)));
    }
}

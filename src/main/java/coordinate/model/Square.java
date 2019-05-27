package coordinate.model;

import java.util.List;

public class Square extends Figure {

    public Square(List<Point> points) {
        super(points);
        checkTwist(getPoints());
    }

    private void checkTwist(Points points) {
        if (!points.isEqualX(0, 1) || !points.isEqualY(0, 2) ||
                !points.isEqualX(3, 2) || !points.isEqualY(3, 1)) {
            throw new IllegalArgumentException("올바른 사각형이 아닙니다");
        }
    }

    @Override
    public double getScore() {
        return getDistance(0, 1) * getDistance(0, 2);
    }
}

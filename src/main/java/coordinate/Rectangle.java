package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Rectangle {
    private final Points points;

    public Rectangle(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        points.sort();
        this.points = points;
        validateRectangle();
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != 4) {
            throw new IllegalArgumentException("직사각형은 4개의 점을 가져야 합니다.");
        }
    }

    private void validateRectangle() {
        if (!(checkLeft() && checkRight() && checkTop() && checkBottom())) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    // 0 : LeftBottom, 1: LeftTop, 2: RightBottom, 3:RightTop
    private boolean checkLeft() {
        return points.get(0).getX() == points.get(1).getX();
    }

    private boolean checkRight() {
        return points.get(2).getX() == points.get(3).getX();
    }

    private boolean checkTop() {
        return points.get(1).getY() == points.get(3).getY();
    }

    private boolean checkBottom() {
        return points.get(0).getY() == points.get(2).getY();
    }
}

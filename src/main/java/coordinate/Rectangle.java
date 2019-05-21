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
        if (!(checkLeftVertical() && checkRightVertical() && checkTopHorizontal() && checkBottomHorizontal())) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    // 0 : LeftBottom, 1: LeftTop, 2: RightBottom, 3:RightTop
    private boolean checkLeftVertical() {
        return points.getX(0) == points.getX(1);
    }

    private boolean checkRightVertical() {
        return points.getX(2) == points.getX(3);
    }

    private boolean checkTopHorizontal() {
        return points.getY(1) == points.getY(3);
    }

    private boolean checkBottomHorizontal() {
        return points.getY(0) == points.getY(2);
    }

    public int area() {
        return (points.getX(2) - points.getX(0)) *
                (points.getY(1) - points.getY(0));
    }
}

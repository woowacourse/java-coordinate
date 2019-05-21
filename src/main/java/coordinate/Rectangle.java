package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Rectangle {
    private static final int LEFT_BOTTOM_POINT = 0;
    private static final int LEFT_TOP_POINT = 1;
    private static final int RIGHT_BOTTOM_POINT = 2;
    private static final int RIGHT_TOP_POINT = 3;
    private static final int POINTS_SIZE = 4;

    private final Points points;

    public Rectangle(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        points.sort();
        this.points = points;
        validateRectangle();
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != POINTS_SIZE) {
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
        return points.getX(LEFT_BOTTOM_POINT) == points.getX(LEFT_TOP_POINT);
    }

    private boolean checkRightVertical() {
        return points.getX(RIGHT_BOTTOM_POINT) == points.getX(RIGHT_TOP_POINT);
    }

    private boolean checkTopHorizontal() {
        return points.getY(LEFT_TOP_POINT) == points.getY(RIGHT_TOP_POINT);
    }

    private boolean checkBottomHorizontal() {
        return points.getY(LEFT_BOTTOM_POINT) == points.getY(RIGHT_BOTTOM_POINT);
    }

    public int area() {
        return calculateWidth() * calculateHeight();
    }

    private int calculateHeight() {
        return points.getY(LEFT_TOP_POINT) - points.getY(LEFT_BOTTOM_POINT);
    }

    private int calculateWidth() {
        return points.getX(RIGHT_BOTTOM_POINT) - points.getX(LEFT_BOTTOM_POINT);
    }


}

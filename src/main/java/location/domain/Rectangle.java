package location.domain;

public class Rectangle extends Figure {
    private final String SAME_LINE_MSG = "세점 이상이 한 선상에 있습니다.";
    private final String NOT_RECTANGLE_MSG = "직사각형이 아닙니다.";
    private Points points;
    public Rectangle(final Points points) {
        checkValid(points);
        checkSamePointValid(points.getPoints());
        this.points = points;
    }

    private void checkValid(final Points points) {
        checkBruteForceSameLine(points);
        checkRectangle(points);
    }

    private void checkRectangle(final Points points) {
        if (isSameDiagonal(points)
                && isSameCenterX(points)
                && isSameCenterY(points)) {
            return;
        }
        throw new IllegalArgumentException(NOT_RECTANGLE_MSG);
    }

    private boolean isSameCenterX(final Points points) {
        return ((points.get(1).getXCoordinate() + points.get(2).getXCoordinate()) / 2)
                == ((points.get(0).getXCoordinate() + points.get(3).getXCoordinate()) / 2);
    }

    private boolean isSameCenterY(final Points points) {
        return ((points.get(1).getyCoordinate() + points.get(2).getyCoordinate()) / 2)
                == ((points.get(0).getyCoordinate() + points.get(3).getyCoordinate()) / 2);
    }

    private boolean isSameDiagonal(final Points points) {
        return points.getTwoPointsDistance(1, 2) == points.getTwoPointsDistance(0, 3);
    }

    private void checkBruteForceSameLine(Points points) {
        checkSameLine(points);
    }

    private void checkSameLine(Points points) {
        if (isSameLine(points)) {
            throw new IllegalArgumentException(SAME_LINE_MSG);
        }
    }

    private boolean isSameLine(Points points) {
        return points.getTwoPointsTilt(0, 1) == points.getTwoPointsTilt(1, 2)
                && points.getTwoPointsTilt(1, 2) == points.getTwoPointsTilt(2, 3)
                && points.getTwoPointsTilt(0, 1) == points.getTwoPointsTilt(2, 3);
    }

    @Override
    public double calculate() {
        return points.getTwoPointsDistance(0, 1) * points.getTwoPointsDistance(0, 2);
    }

    @Override
    public Points getPoints() {
        return this.points;
    }

}

package coordinate.domain;

public class Rectangle extends Figure implements CalculableFigure{
    private static final int NUM_OF_POINT = 4;

    Rectangle(Points points) {
        super(points);
    }

    @Override
    void validateConfigurableBy(Points points) {
        validateSizeOf(points);
        validateRectangle(points);
    }

    void validateSizeOf(Points points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 " + NUM_OF_POINT + " 개여야 합니다.");
        }
    }

    private void validateRectangle(Points points) {
        for (Point point : points.getAllPoints()) {
            validateXPair(points, point);
            validateYPair(points, point);
        }
    }

    private void validateXPair(Points points, Point point) {
        if (!points.hasXPairOf(point))
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private void validateYPair(Points points, Point point) {
        if (!points.hasYPairOf(point))
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    @Override
    public double calculateArea() {
        StraightLine horizontalLine = new StraightLine(points.findXPairOf(points.getBasePoint()));
        StraightLine verticalLine = new StraightLine(points.findYPairOf(points.getBasePoint()));
        return horizontalLine.calculateArea() * verticalLine.calculateArea();
    }
}

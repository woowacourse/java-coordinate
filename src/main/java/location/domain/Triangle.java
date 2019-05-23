package location.domain;

public class Triangle extends Shape {
    private static final String SAME_LINE_MSG = "모든 선이 같은 선상에 있습니다.";
    private static final int SQUARE = 2;
    private final Points points;

    public Triangle(Points points) {
        super(points);
        checkValid(points);
        this.points = points;
    }

    private void checkValid(Points points) {
        isSameLine(points);
    }

    private void isSameLine(Points points) {
        if (isSameXCoordinate(points, 0, 1)
                && isSameXCoordinate(points, 1, 2)
                && isSameXCoordinate(points, 0, 2)) {
            throw new IllegalArgumentException(SAME_LINE_MSG);
        }
        if (isSameYCoordinate(points, 0, 1)
                && isSameYCoordinate(points, 1, 2)
                && isSameYCoordinate(points, 0, 2)) {
            throw new IllegalArgumentException(SAME_LINE_MSG);
        }
    }

    private boolean isSameXCoordinate(Points points, int index1, int index2) {
        return points.get(index1).getX() == points.get(index2).getX();
    }

    private boolean isSameYCoordinate(Points points, int index1, int index2) {
        return points.get(index1).getY() == points.get(index2).getY();
    }

    private double calculateLine(final Point point1, final Point point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }

    @Override
    public Double calculate() {
        double frontTerm = 4 * Math.pow(calculateLine(points.get(0), points.get(1)), SQUARE) * Math.pow(calculateLine(points.get(1), points.get(2)), SQUARE);
        double rearTerm = (Math.pow(calculateLine(points.get(0), points.get(1)), SQUARE) + Math.pow(calculateLine(points.get(1), points.get(2)), SQUARE) - Math.pow(calculateLine(points.get(2), points.get(0)), 2));
        return Math.sqrt(frontTerm - Math.pow(rearTerm, SQUARE)) / 4;
    }
}

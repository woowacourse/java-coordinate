package coordinate.domain;

public final class Square extends Figure {
    public static final int NUMBER_OF_POINTS = 4;

    public Square(final Points points) {
        super(points);
    }

    protected void validate() {
        validateSize();
        validateRectangle();
    }

    private void validateSize() {
        super.validateSize(NUMBER_OF_POINTS);
    }

    private void validateRectangle() {
        double diagonal = getDiagonal(getPoint(0), getPoint(2));
        double otherDiagonal = getDiagonal(getPoint(1), getPoint(3));
        if (diagonal != otherDiagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    private double getDiagonal(Point onePoint, Point anotherPoint) {
        return Math.hypot(onePoint.length(anotherPoint), onePoint.length(anotherPoint));
    }

    @Override
    public double area() {
        return makeLines().lengths().get(0) * makeLines().lengths().get(2);
    }
}

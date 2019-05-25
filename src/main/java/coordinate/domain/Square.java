package coordinate.domain;

import coordinate.domain.generator.LinesSquareGenerator;


public final class Square extends RealFigure {
    public static final int NUMBER_OF_POINTS = 4;

    public Square(final Points points) {
        super(points, new LinesSquareGenerator(points));
        validateRectangle();
    }

    private void validateRectangle() {
        Points points = super.getPoints();
        double diagonal1 = getDiagonal(points, 0, 2);
        double diagonal2 = getDiagonal(points, 1, 3);
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    private double getDiagonal(final Points points, final int i, final int i2) {
        return Math.hypot(points.get(i).length(points.get(i2)), points.get(i).length(points.get(i2)));
    }

    @Override
    public int size() {
        return NUMBER_OF_POINTS;
    }

    @Override
    public double area() {
        return super.getLines().lengths().get(0) * super.getLines().lengths().get(2);
    }

    @Override
    public String getName() {
        return "사각형";
    }
}

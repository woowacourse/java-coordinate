package coordinate.domain;

import coordinate.domain.generator.LinesSquareGenerator;


public final class Square extends Figure {
    private static final int NUMBER_OF_POINTS = 4;

    public Square(final Points points) {
        super(points, new LinesSquareGenerator(points));
        validate();
    }

    protected void validate() {
        validateSize();
        validateRectangle();
    }

    private void validateSize() {
        super.validateSize(NUMBER_OF_POINTS);
    }

    private void validateRectangle() {
        Points points = super.getPoints();
        double distance1 = Math.hypot(points.get(0).getX() - points.get(2).getX(), points.get(0).getY() - points.get(2).getY());
        double distance2 = Math.hypot(points.get(1).getX() - points.get(3).getX(), points.get(1).getY() - points.get(3).getY());
        if (distance1 != distance2) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    @Override
    public double area() {
        return super.getLines().lengths().get(0) * super.getLines().lengths().get(2);
    }
}

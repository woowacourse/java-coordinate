package coordinate.domain;

import coordinate.domain.generator.LinesSquareGenerator;


public final class Square extends Figure {
    private static final int NUMBER_OF_POINTS = 4;

    public Square(final Points points) {
        super(points, new LinesSquareGenerator(points));
    }

    protected void validate() {
        validateSize();
        validateRectangle();
    }

    private void validateSize() {
        super.validateSize(NUMBER_OF_POINTS);
    }

    private void validateRectangle() {
        double diagonal1 = super.getLines().lengths().get(4);
        double diagonal2 = super.getLines().lengths().get(5);
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    @Override
    public double area() {
        return super.getLines().lengths().get(0) * super.getLines().lengths().get(2);
    }
}

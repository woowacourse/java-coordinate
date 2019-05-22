package coordinate.domain;

import coordinate.domain.generator.LinesTriangleGenerator;

public final class Triangle extends Figure {
    private static final int NUMBER_OF_POINTS = 3;

    public Triangle(final Points points) {
        super(points, new LinesTriangleGenerator(points));
    }

    @Override
    protected void validate() {
        validateSize();
    }

    private void validateSize() {
        super.validateSize(NUMBER_OF_POINTS);
    }

    @Override
    public double area() {
        Lines lines = super.getLines();
        double a = lines.lengths().get(0);
        double b = lines.lengths().get(1);
        double c = lines.lengths().get(2);

        double s = (a+b+c) / 2.0d;
        double x = (s * (s - a) * (s - b) * (s - c));
        double area = Math.sqrt(x);
        return area;
    }
}

package coordinate.domain;

import coordinate.domain.generator.LinesTriangleGenerator;

public final class Triangle extends Figure {
    private static final int NUMBER_OF_POINTS = 3;
    private static final double HERON_DIVIDE_NUMBER = 2.0;

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
        return Math.sqrt(calculateX(lines, calculateS(lines)));
    }

    private double calculateS(final Lines lines) {
        return lines.lengths()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum() / HERON_DIVIDE_NUMBER;
    }

    private double calculateX(final Lines lines, final double s) {
        return s * lines.lengths()
                .stream()
                .mapToDouble(length -> s - length)
                .reduce(1, (a, b) -> a * b);
    }

    @Override
    public String toString() {
        return "삼각형";
    }
}

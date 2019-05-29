package coordinate.domain;

public final class Triangle extends Figure {
    public static final int NUMBER_OF_POINTS = 3;
    private static final double HERON_DIVIDE_NUMBER = 2.0;
    private static final int DEFAULT_MULTIPLY_NUMBER = 1;

    public Triangle(final Points points) {
        super(points);
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
        Lines lines = makeLines();
        return Math.sqrt(calculateTriangleArea(lines, halfOfTotalTriangleLength(lines)));
    }

    private double halfOfTotalTriangleLength(final Lines lines) {
        return lines.lengths()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum() / HERON_DIVIDE_NUMBER;
    }

    private double calculateTriangleArea(final Lines lines, final double halfOfTotalTriangleLength) {
        return halfOfTotalTriangleLength * lines.lengths()
                .stream()
                .mapToDouble(triangleLength -> halfOfTotalTriangleLength - triangleLength)
                .reduce(DEFAULT_MULTIPLY_NUMBER, (former, latter) -> former * latter);
    }
}

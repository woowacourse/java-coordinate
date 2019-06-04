package coordinate.domain;

public class FigureGenerator {
    private static final int NUMBER_OF_POINTS_FOR_LINE = 2;
    private static final int NUMBER_OF_POINTS_FOR_TRIANGLE = 3;
    private static final int NUMBER_OF_POINTS_FOR_RECTANGLE = 4;

    public static Figure generate(Points points) {
        if (points.hasSameSizeWith(NUMBER_OF_POINTS_FOR_LINE)) {
            return new Line(points);
        }

        if (points.hasSameSizeWith(NUMBER_OF_POINTS_FOR_TRIANGLE)) {
            return new Triangle(points);
        }

        if (points.hasSameSizeWith(NUMBER_OF_POINTS_FOR_RECTANGLE)) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException("좌표의 개수는 2~4개만 가능합니다.");
    }
}

package coordinate.domain;


public class FigureFactory {
    private static final int TRIANGLE_LIMIT_SIZE = 3;
    private static final int RECTANGLE_LIMIT_SIZE = 4;

    public static Figure generateFigure(Points points) {
        if (points.getSize() == TRIANGLE_LIMIT_SIZE) {
            return new Triangle(points);
        }
        if (points.getSize() == RECTANGLE_LIMIT_SIZE) {
            return new Rectangle(points);
        }
        return new Line(points);
    }

}

package coordinatecalculator.model;

import java.util.List;

public class FigureFactory {
    private static final int LINE_COORDINATES = 2;
    private static final int TRIANGLE_COORDINATES = 3;
    private static final int RECTANGLE_COORDINATES = 4;

    public static PlaneFigure createFigure(List<Coordinate> coordinates) {
        if (isLine(coordinates)) {
            return new Line(coordinates);
        }
        if (isTriangle(coordinates)) {
            return new Triangle(coordinates);
        }
        if (isRectangle(coordinates)) {
            return new Rectangle(coordinates);
        }
        throw new IllegalArgumentException("잘못된 좌표 개수입니다.");
    }

    private static boolean isLine(List<Coordinate> coordinates) {
        return coordinates.size() == LINE_COORDINATES;
    }

    private static boolean isTriangle(List<Coordinate> coordinates) {
        return coordinates.size() == TRIANGLE_COORDINATES;
    }

    private static boolean isRectangle(List<Coordinate> coordinates) {
        return coordinates.size() == RECTANGLE_COORDINATES;
    }
}

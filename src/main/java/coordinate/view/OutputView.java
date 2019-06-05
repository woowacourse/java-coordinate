package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeType;
import coordinate.domain.Value;

import java.util.List;

public class OutputView {
    private static final int MAX_X = 25;
    private static final int MAX_Y = 25;
    private static final String EXIST_POINT = " · ";
    private static final String EMPTY_POINT = "   ";
    private static final String EMPTY_LINE = "\n";
    private static final String X_AXIS_BOUND = "    ";
    private static final String Y_AXIS_LINE = "|";
    private static final String ORIGIN_POINT = "+";
    private static final String X_AXIS_LINE = "---";


    public static void printCoordinate(List<Point> points) {
        boolean[][] coordinates = new boolean[MAX_Y][MAX_X];
        initCoordinates(coordinates);
        drawPoints(points, coordinates);
        printPoints(coordinates);
        printXAxis();
    }

    private static void initCoordinates(boolean[][] coordinates) {
        for (int i = 0; i < MAX_Y; i++) {
            initCoordinateX(coordinates, i);
        }
    }

    private static void initCoordinateX(boolean[][] coordinates, int i) {
        for (int j = 0; j < MAX_X; j++) {
            coordinates[i][j] = false;
        }
    }

    private static void drawPoints(List<Point> points, boolean[][] coordinates) {
        for (Point point : points) {
            Value valueY = point.getValueY();
            Value valueX = point.getValueX();
            coordinates[valueY.getNum()][valueX.getNum()] = true;
        }
    }

    private static void printPoints(boolean[][] coordinates) {
        for (int i = MAX_Y - 1; i >= 1; i--) {
            StringBuilder sb = initStringBuilder(i);
            printPointsX(coordinates[i], sb);
            System.out.println(sb.toString());
        }
    }

    private static void printPointsX(boolean[] coordinate, StringBuilder sb) {
        for (int j = 0; j < MAX_X; j++) {
            if (coordinate[j]) {
                sb.append(EXIST_POINT);
                continue;
            }
            sb.append(EMPTY_POINT);
        }
    }

    private static StringBuilder initStringBuilder(int index) {
        StringBuilder sb = new StringBuilder();
        if (index % 2 == 0) {
            sb.append(String.format("%3s", index + Y_AXIS_LINE));
            return sb;
        }
        return sb.append(String.format("%3s", Y_AXIS_LINE));
    }

    private static void printXAxis() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_X - 1; i++) {
            printZeroPoint(sb, i);
            sb.append(X_AXIS_LINE);
        }

        sb.append(EMPTY_LINE + String.format("%3s", 0));

        for (int i = 2; i < MAX_X; i = i + 2) {
            sb.append(String.format("%6s", i));
        }
        System.out.println(sb.toString());
    }

    private static void printZeroPoint(StringBuilder sb, int i) {
        if (i == 0) {
            sb.append(String.format("%3s", ORIGIN_POINT));
        }
    }

    public static void printArea(Shape shape) {
        if (ShapeType.LINE == ShapeType.valueOf(shape.getPointSize())) {
            System.out.println("두점 사이의 거리는 " + shape);
        }
        if (ShapeType.TRIANGLE == ShapeType.valueOf(shape.getPointSize())) {
            System.out.println("삼각형의 넓이는 " + shape);
        }
        if (ShapeType.RECTANGLE == ShapeType.valueOf(shape.getPointSize())) {
            System.out.println("사각형의 넓이는 " + shape);
        }
    }
}

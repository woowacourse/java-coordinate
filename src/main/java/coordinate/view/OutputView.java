package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Shape;

import java.util.List;

//(10,10)-(22,10)-(22,18)-(10,18)
public class OutputView {
    private static final int MAX_X = 25;
    private static final int MAX_Y = 25;
    private static final String EXIST_POINT = " · ";
    private static final String EMPTY_POINT = "   ";
    private static final String EMPTY_LINE = "\n";
    private static final String X_AXIS_NUMBER = "0     2      4     6      8     10    12    14    16    18    20    22    24";
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
            for (int j = 0; j < MAX_X; j++) {
                coordinates[i][j] = false;
            }
        }
    }

    private static void drawPoints(List<Point> points, boolean[][] coordinates) {
        for (Point point : points) {
            coordinates[point.getY()][point.getX()] = true;
        }
    }

    private static void printPoints(boolean[][] coordinates) {
        for (int i = MAX_Y - 1; i >= 1; i--) {
            StringBuilder sb = initStringBuilder(i);
            for (int j = 0; j < MAX_X; j++) {
                if (coordinates[i][j]) {
                    sb.append(EXIST_POINT);
                    continue;
                }
                sb.append(EMPTY_POINT);
            }
            System.out.println(sb.toString());
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
        for (int i = 0; i < MAX_X; i++) {
            if (i == 0) {
                sb.append(String.format("%3s", ORIGIN_POINT));
            }
            sb.append(X_AXIS_LINE);
        }
        sb.append(EMPTY_LINE + X_AXIS_NUMBER);
        System.out.println(sb.toString());
    }

    public static void printArea(Shape shape) {
        System.out.println(shape);
    }
}

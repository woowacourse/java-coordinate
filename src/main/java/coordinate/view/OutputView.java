package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Shape;

import java.util.ArrayList;
import java.util.Collections;
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
        printPoints(points);
        printXAxis();
    }

    private static void printPoints(List<Point> points) {
        List<Point> sortedPoints = sortPoints(points);
        for (int y = MAX_Y - 1; y >= 1; y--) {
            String line = getLine(y, sortedPoints);
            System.out.println(line);
        }
    }

    private static List<Point> sortPoints(List<Point> points) {
        List<Point> tempPoints = new ArrayList<>(points);
        Collections.sort(tempPoints);
        return tempPoints;
    }

    private static String getLine(int y, List<Point> points) {
        StringBuilder sb = initStringBuilder(y);
        for (int x = 0; x < MAX_X; x++) {
            sb.append(getPointX(x, points, y));
        }
        return sb.toString();
    }

    private static String getPointX(int x, List<Point> points, int y) {
        if (checkPoints(x, points, y)) {
            return EXIST_POINT;
        }
        return EMPTY_POINT;
    }

    private static boolean checkPoints(int x, List<Point> points, int y) {
        for (Point point : points) {
            if (point.getX() == x && point.getY() == y) {
                removePoint(points, point);
                return true;
            }
        }
        return false;
    }

    private static void removePoint(List<Point> points, Point point) {
        points.remove(point);
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
            isZero(sb, i);
        }
        sb.append(EMPTY_LINE + X_AXIS_NUMBER);
        System.out.println(sb.toString());
    }

    private static void isZero(StringBuilder sb, int i) {
        if (i == 0) {
            sb.append(String.format("%3s", ORIGIN_POINT));
        }
        sb.append(X_AXIS_LINE);
    }

    public static void printArea(Shape shape) {
        System.out.println(shape);
    }
}

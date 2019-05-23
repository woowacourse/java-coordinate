package coordinatecalculator.view;

import coordinatecalculator.model.Point;
import coordinatecalculator.model.Points;

public class OutputView {
    private static final int COORDINATE_WIDTH = 25;
    private static final int COORDINATE_HEIGHT = 25;
    private static final int COORDINATE_START = 0;
    private static final String BLANK = " ";
    private static final String Y_AXIS = "|";
    private static final String X_AXIS = "-";
    private static final String POINT = "ㆍ";

    public static void showCoordinate(Points points) {
        printCoordinate(points);
        printDistanceResult(points);
    }

    private static void printCoordinate(Points points) {
        boolean[][] coordinate = new boolean[COORDINATE_HEIGHT][COORDINATE_WIDTH];
        for (Point point : points.getPoints()) {
            coordinate[point.getxPoint().getValue()][point.getyPoint().getValue()] = true;
        }
        printCoordinateAllLines(coordinate);
    }

    private static void printCoordinateAllLines(boolean[][] coordinate) {
        for (int i = COORDINATE_HEIGHT - 1; i > COORDINATE_START; i--) {
            System.out.print(Y_AXIS);
            printCoordinateOneLine(coordinate[i]);
            System.out.println();
        }
        for (int i = COORDINATE_START; i < COORDINATE_WIDTH; i++) {
            System.out.print(X_AXIS);
        }
        System.out.println();
    }

    private static void printCoordinateOneLine(boolean[] oneLine) {
        for (int j = COORDINATE_START + 1; j < COORDINATE_WIDTH; j++) {
            System.out.print(getBox(oneLine[j]));
        }
    }

    private static String getBox(boolean isPoint) {
        if (isPoint) {
            return POINT;
        }
        return BLANK;
    }

    private static void printDistanceResult(Points points) {
        System.out.print(String.format("두 점 사이의 거리는 %f", points.distanceResult()));
    }
}

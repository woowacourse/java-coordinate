package coordinate.view;

import coordinate.domain.nonefigure.PointGroup;

public class OutputView {
    private static final int COORDINATE_PLANE_SIZE = 24;
    private static final String HORIZONTAL_LINE = "|";
    private static final String VERTICAL_LINE = "---";
    private static final String EMPTY = "   ";
    private static final String ORIGIN = "+";
    private static final String COORDINATES = "@";

    public static void printCoordinatePlane(PointGroup points) {
        for (int i = COORDINATE_PLANE_SIZE; i > 0; i--) {
            drawRow(i, points);
        }
        drawOrigin(points.have(0, 0));
        drawXAxis(points);
    }

    private static void drawOrigin(boolean have) {
        System.out.print(EMPTY);
        if (have) System.out.print(COORDINATES);
        else System.out.print(ORIGIN);
    }

    private static void drawXAxis(PointGroup points) {
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            if (points.have(i, 0)) System.out.print("-" + COORDINATES + "-");
            else System.out.print(VERTICAL_LINE);
        }
        System.out.println();
        for (int i = 0; i <= COORDINATE_PLANE_SIZE; i++) {
            drawXAxisNumber(i);
        }
        System.out.println();
    }

    private static void drawXAxisNumber(int i) {
        if (i % 2 == 0) {
            if (i == 0) System.out.print("  0 ");
            else {
                System.out.printf("%2d ", i);
            }
        } else {
            System.out.print(EMPTY);
        }
    }

    private static void drawRow(int rowNumber, PointGroup points) {
        drawYAxis(rowNumber, points);
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            System.out.print(drawNumber(points.have(i, rowNumber)));
        }
        System.out.println();
    }

    private static void drawYAxis(int rowNumber, PointGroup points) {
        if (rowNumber % 2 == 0) {
            System.out.printf("%3d", rowNumber);
        } else {
            System.out.print(EMPTY);
        }
        if (points.have(0, rowNumber)) {
            System.out.print(COORDINATES);
        } else {
            System.out.print(HORIZONTAL_LINE);
        }
    }

    public static String drawNumber(boolean havePoint) {
        if (havePoint) {
            return " " + COORDINATES + " ";
        }
        return EMPTY;
    }

    public static void printLineLength(double lineLength) {
        System.out.println("두 점 사이 거리는 " + lineLength);
    }

    public static void printArea(String figure, double area) {
        System.out.println(figure + " 넓이는 " + area);
    }
}


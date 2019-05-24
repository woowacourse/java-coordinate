package coordinate.view;

import coordinate.domain.figure.AreaCalculable;
import coordinate.domain.figure.Figure;
import coordinate.domain.figure.Line;
import coordinate.util.CoordinatePlaneDrawer;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final int COORDINATE_PLANE_SIZE = 24;

    public static void printCoordinateResult(Figure figure) {
        printCoordinatePlane(figure);
        printSizeResult(figure);
    }

    private static void printCoordinatePlane(Figure figure) {
        CoordinatePlaneDrawer drawer = new CoordinatePlaneDrawer(COORDINATE_PLANE_SIZE, figure);
        System.out.println();
        System.out.println(drawer.print());
    }

    private static void printSizeResult(Figure figure) {
        if (figure instanceof AreaCalculable) {
            OutputView.printArea(figure.toString(), ((AreaCalculable) figure).area());
            return;
        }
        OutputView.printLineLength(((Line) figure).length());
    }

    private static void printLineLength(double lineLength) {
        System.out.println("두 점 사이 거리는 " + lineLength);
    }

    private static void printArea(String figure, double area) {
        System.out.println(figure + " 넓이는 " + area);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + NEW_LINE);
    }
}


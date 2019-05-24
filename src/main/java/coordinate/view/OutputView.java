package coordinate.view;

import coordinate.domain.Figure.AreaCalculable;
import coordinate.domain.Figure.Figure;
import coordinate.domain.Figure.Line;
import coordinate.domain.point.PointGroup;
import coordinate.util.CoordinatePlaneDrawer;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final int COORDINATE_PLANE_SIZE = 24;

    public static void printCoordinatePlane(PointGroup points) {
        CoordinatePlaneDrawer drawer = new CoordinatePlaneDrawer(COORDINATE_PLANE_SIZE, points);
        System.out.println();
        System.out.println(drawer.print());
    }

    public static void printFigureResult(Figure figure) {
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


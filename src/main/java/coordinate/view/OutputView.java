package coordinate.view;

import coordinate.domain.figure.Figure;
import coordinate.util.CalculateMsgType;
import coordinate.util.CoordinatePlaneDrawer;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public static void printCoordinateResult(Figure figure) {
        printCoordinatePlane(figure);
        printCalculateResult(figure);
    }

    private static void printCoordinatePlane(Figure figure) {
        CoordinatePlaneDrawer drawer = new CoordinatePlaneDrawer(figure);
        System.out.println();
        System.out.println(drawer.print());
    }

    private static void printCalculateResult(Figure figure) {
        try {
            System.out.println(CalculateMsgType.messageOf(figure) + figure.calculate());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + NEW_LINE);
    }
}


package coordinate.view;

import coordinate.domain.AreaType;
import coordinate.domain.CalculableFigure;
import coordinate.domain.Figure;
import coordinate.ui.CartesianPlane;
import coordinate.ui.Row;
import coordinate.ui.Tile;

public class OutputView {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static void printErrorMsg(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printAreaOf(CalculableFigure figure) {
        System.out.println(NEWLINE + AreaType.getAreaTypeMessage(figure.getNumOfPoints()) + figure.calculateArea());
    }

    public static void printGraph(CartesianPlane plane) {
        System.out.print(NEWLINE);
        for (Row row : plane.getRows()) {
            for (Tile tile : row.getTiles()) {
                System.out.print(String.format("%3s", tile));
            }
            System.out.print(NEWLINE);
        }
    }
}

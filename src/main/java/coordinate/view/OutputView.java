package coordinate.view;

import coordinate.domain.Figure;

public class OutputView {
    public static void printFigure(Figure figure) {
        System.out.println(figure.getPlaneCoordinates());
        System.out.println(figure);
    }
}

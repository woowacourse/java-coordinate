package coordinate.view;

import coordinate.domain.Figure;

public class OutputView {
    public static void printFigure(Figure figure) {
        System.out.println(figure.getPlaneCoordinates().toString());
        System.out.println(figure.toString());
    }

    public static void printMessage(String Message) {
        System.out.println(Message);
    }
}

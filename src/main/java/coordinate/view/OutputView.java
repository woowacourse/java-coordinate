package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Line;
import coordinate.domain.Rectangle;
import coordinate.domain.Triangle;

public class OutputView {

    private static final String LINE_PRINT_MESSAGE = "두 점 사이의 거리는 ";
    private static final String TRIANGLE_PRINT_MESSAGE = "삼각형의 넓이는 ";
    private static final String RECTANGLE_PRINT_MESSAGE = "직사각형의 넓이는 ";

    public static void printFigure(Figure figure) {
        System.out.println(figure.getPlaneCoordinates().toString());
        if (figure instanceof Line) {
            System.out.println(LINE_PRINT_MESSAGE + ((Line) figure).length());
        }
        if (figure instanceof Triangle) {
            System.out.println(TRIANGLE_PRINT_MESSAGE + ((Triangle) figure).area());
        }
        if (figure instanceof Rectangle) {
            System.out.println(RECTANGLE_PRINT_MESSAGE + ((Rectangle) figure).area());
        }
    }

    public static void printMessage(String Message) {
        System.out.println(Message);
    }
}

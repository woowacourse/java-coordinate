package coordinatecalculator.view;

import coordinatecalculator.model.Figure;
import coordinatecalculator.model.Graph;

public class OutputView {
    private static int NUMBER_OF_POINTS_IN_LINE = 2;
    private static int NUMBER_OF_POINTS_IN_TRIANGLE = 3;
    private static int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    private static String X_AXIS_BARS =  "  ----------------------------------------------------------";
    private static String X_AXIS_NUMBERS = "  0   2   4   6   8  10  12  14  16  18  20  22  24";

    public static void printResult(Graph graph, Figure figure){
        System.out.println(graph.toString());
        System.out.println(X_AXIS_BARS);
        System.out.println(X_AXIS_NUMBERS);
        if (figure.getPointSize() == NUMBER_OF_POINTS_IN_LINE) {
            System.out.println("선분의 길이는 " + figure.calculateFigureInformation());
        }
        if (figure.getPointSize() == NUMBER_OF_POINTS_IN_TRIANGLE) {
            System.out.println("삼각형의 넓이는 " + figure.calculateFigureInformation());
        }
        if (figure.getPointSize() == NUMBER_OF_POINTS_IN_RECTANGLE) {
            System.out.println("사각형의 넓이는 " + figure.calculateFigureInformation());
        }
    }
}

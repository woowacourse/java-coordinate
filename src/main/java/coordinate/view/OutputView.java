package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Graph;

public class OutputView {
    private static int NUMBER_OF_POINTS_IN_LINE = 2;
    private static int NUMBER_OF_POINTS_IN_TRIANGLE = 3;
    private static int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    private static String xAxisLine =  "  ----------------------------------------------------------";
    private static String xAxisNumber = "  0   2   4   6   8  10  12  14  16  18  20  22  24";

    public static void printGraph(Graph graph, Figure figure){
        System.out.println(graph.toString());
        //System.out.println("  ----------------------------------------------------------");
        //System.out.println("  0   2   4   6   8  10  12  14  16  18  20  22  24");
        System.out.println(xAxisLine);
        System.out.println(xAxisNumber);
        if (figure.getPoints().size() == NUMBER_OF_POINTS_IN_LINE) {
            System.out.println("선분의 길이는 " + figure.distance());
        }
        if (figure.getPoints().size() == NUMBER_OF_POINTS_IN_TRIANGLE) {
            System.out.println("삼각형의 넓이는 " + figure.area());
        }
        if (figure.getPoints().size() == NUMBER_OF_POINTS_IN_RECTANGLE) {
            System.out.println("사각형의 넓이는 " + figure.area());
        }
    }
}

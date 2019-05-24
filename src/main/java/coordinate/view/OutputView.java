package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Line;

public class OutputView {

    private static final String GRAPH_LINE = "   ----------------------------------------------------------";
    private static final String GRAPH_X_AXIS = "   0   2   4   6   8  10  12  14  16  18  20  22  24";
    private static final String DISTANCE_MESSAGE = "두 점 사이 거리는";
    private static final String AREA_MESSAGE = "넓이는 ";

    public static void printFigurePoints(Figure figure){
        Graph graph = new Graph();
        graph.setPosition(figure.getPoints());

        System.out.println(graph.toString());
        System.out.println(GRAPH_LINE);
        System.out.println(GRAPH_X_AXIS);

        if (figure.area() == 0){
            System.out.println(DISTANCE_MESSAGE + new Line(figure.getPoints()).distance());
        }
        System.out.println(AREA_MESSAGE + figure.area());
    }
}

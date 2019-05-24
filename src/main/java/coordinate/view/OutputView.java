package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Line;

public class OutputView {
    public static void printFigurePoints(Figure figure){
        Graph graph = new Graph();
        graph.setPosition(figure.getPoints());

        System.out.println(graph.toString());
        System.out.println("  ----------------------------------------------------------");
        System.out.println("  0   2   4   6   8  10  12  14  16  18  20  22  24");
        if (figure.area() == 0){
            System.out.println("두 점 사이 거리는" + new Line(figure.getPoints()).distance());
        }
        System.out.println("넓이는 " + figure.area() + "입니다.");
    }
}

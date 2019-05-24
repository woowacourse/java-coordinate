package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Graph;

public class OutputView {
    public static void printGraph(Graph graph, Figure figure){
        System.out.println(graph.toString());
        System.out.println("  ----------------------------------------------------------");
        System.out.println("  0   2   4   6   8  10  12  14  16  18  20  22  24");
        if (figure.getPoints().size() == 2) {
            //라인 길이
        }
        System.out.println("넓이는 " + figure.area() + "입니다.");
    }
}

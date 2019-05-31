package coordinate.view;

import coordinate.domain.graph.Graph;
import coordinate.domain.shape.Shape;

public class OutputView {
    public static void printArea(Shape shape) {
        System.out.println(shape);
    }

    public static void printGraph(Graph graph) {
        System.out.println(graph);
    }
}

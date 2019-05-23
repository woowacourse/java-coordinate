package coordinate.view;

import coordinate.model.Graph;

public class OutputView {
    public static void printGraph(Graph graph){
        System.out.println(graph.toString());
        System.out.println("  ----------------------------------------------------------");
        System.out.println("  0   2   4   6   8  10  12  14  16  18  20  22  24");
    }
}

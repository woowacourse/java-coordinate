package coordinate.view;

import coordinate.model.Line;

public class OutputView {
    public static void printResult(Line line){
        System.out.print("두 점 사이의 거리는 ");
        System.out.println(line.getLength());
    }
}

package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Rectangular;

public class OutputView {
    public static void printResult(Line line){
        System.out.print("두 점 사이의 거리는 ");
        System.out.println(line.getLength());
    }

    public static void printResult(Rectangular rectangular){
        System.out.print("사각형 넓이는 ");
        System.out.println(rectangular.getArea());
    }
}

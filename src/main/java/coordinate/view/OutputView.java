package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Line;

public class OutputView {

    public static void printResult(final Figure figure) {
        System.out.println("넓이는 " + figure.area());
    }

    public static void printResult(final Line line) {
        System.out.println("두 점 사이 거리는 " + line.length());
    }
}

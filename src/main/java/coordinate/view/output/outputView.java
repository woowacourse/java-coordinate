package coordinate.view.output;

import coordinate.domain.Line;

public class outputView {
    public static void outputDistanceLine(Line line) {
        System.out.println("두 점의 거리는" + line.calculateDistance());
    }
}

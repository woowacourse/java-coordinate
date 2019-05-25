package coordinate;

import coordinate.domain.Point;
import coordinate.view.InputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = InputView.inputCoordinate();
        for (Point point : points) {
            System.out.println(point.getX() + " , " + point.getY());
        }
    }
}

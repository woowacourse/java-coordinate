package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.PointParser;
import coordinate.domain.StraightLine;
import coordinate.view.InputView;

import java.util.List;

public class CoordinateCalculator {
    public static void main(String[] args) {
        Figure figure = createFigure();
    }

    private static Figure createFigure() {
        List<Point> points = getPoints();
        return new StraightLine(points);
    }

    private static List<Point> getPoints() {
        try {
            String rawInput = InputView.inputPoints();
            return PointParser.parse(rawInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPoints();
        }
    }
}

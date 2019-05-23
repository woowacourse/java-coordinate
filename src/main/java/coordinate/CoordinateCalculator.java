package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.PointParser;
import coordinate.domain.StraightLine;
import coordinate.ui.CartesianPlane;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class CoordinateCalculator {
    public static void main(String[] args) {
        Figure figure = getFigure();

        CartesianPlane plane = new CartesianPlane();
        plane.drawPoints(figure);
        OutputView.printGraph(plane);
        OutputView.printAttributeOf(figure);
    }

    private static Figure getFigure() {
        try {
            return FigureFactory.getFigureOf(getPoints());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            return getFigure();
        }
    }

    private static List<Point> getPoints() {
        String rawInput = InputView.inputPoints();
        return PointParser.parse(rawInput);
    }
}

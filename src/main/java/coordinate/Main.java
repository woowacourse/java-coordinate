package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

    public static void main(String[] args) {
        Shape shape = createShape();
        OutputView.printCoordinate(shape);
        OutputView.printResult(shape);
    }

    private static Shape createShape() {
            try {
                List<Point> points = makePoints(InputView.inputPoint());
                return Shape.creator.get(points.size()).apply(points);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                return createShape();
            }
    }

    private static List<Point> makePoints(List<String> inputs) {
        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
            matcher.matches();
            PointNumber x = new PointNumber(Integer.parseInt(matcher.group(1)));
            PointNumber y = new PointNumber(Integer.parseInt(matcher.group(3)));
            points.add(new Point(x, y));
        }
        return points;
    }
}

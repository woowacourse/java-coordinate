package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

    public static void main(String[] args) {
        Point p1 = new Point(new PointNumber(0),new PointNumber(0));
        Point p2 = new Point(new PointNumber(5),new PointNumber(6));
        Point p3 = new Point(new PointNumber(13),new PointNumber(17));
        OutputView.printCoordinate(Arrays.asList(p1,p2,p3));
    }

    static Line createLine() {
        try {
            return new Line(makePoints(InputView.inputPoint()));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createLine();
        }
    }

    static Square createRectangular() {
        try {
            return new Square(makePoints(InputView.inputPoint()));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createRectangular();
        }
    }

    static Triangle createTriangle() {
        try {
            return new Triangle(makePoints(InputView.inputPoint()));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createTriangle();
        }
    }

    static List<Point> makePoints(List<String> inputs) {
        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
            PointNumber x = new PointNumber(Integer.parseInt(matcher.group(1)));
            PointNumber y = new PointNumber(Integer.parseInt(matcher.group(1)));
            points.add(new Point(x, y));
        }
        return points;
    }
}

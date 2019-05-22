package coordinate;

import coordinate.model.Point;
import coordinate.model.PointNumber;
import coordinate.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

    public static void main(String[] args) {
        InputView.inputPoint();
    }

    List<Point> makePoints(List<String> inputs) {
        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
            PointNumber x = new PointNumber(Integer.parseInt(matcher.group(1)));
            PointNumber y = new PointNumber(Integer.parseInt(matcher.group(1)));
            points.add(new Point(x,y));
        }
        return points;
    }
}

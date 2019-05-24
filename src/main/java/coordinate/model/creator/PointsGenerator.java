package coordinate.model.creator;

import coordinate.model.Point;
import coordinate.model.Value;

import java.util.*;

public class PointsGenerator {

    public static List<Point> makePoints(String data) {
        Set<Point> points = new HashSet<>();
        List<String> values = Splitter.splitValue(data);

        for (int i = 0; i < values.size(); i = i + 2) {
            points.add(new Point(new Value(Integer.parseInt(values.get(i))), new Value(Integer.parseInt(values.get(i + 1)))));
        }

        checkSamePoint(values, points);
        return new ArrayList<>(points);
    }

    private static void checkSamePoint(List<String> values, Set<Point> points) {
        if (values.size() / 2 != points.size()) {
            throw new IllegalArgumentException();
        }
    }
}

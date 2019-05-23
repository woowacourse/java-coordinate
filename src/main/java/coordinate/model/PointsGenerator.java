package coordinate.model;

import java.util.*;

public class PointsGenerator {

    public static List<Point> makePoints(String data) {
        List<Point> points = new ArrayList<>();
        List<String> temp = ValueGenerator.splitCoordinates(data);
        Collections.sort(temp);
        List<String> values = ValueGenerator.splitValue(temp);

        for (int i = 0; i < values.size(); i = i + 2) {
            points.add(new Point(new Value(values.get(i)), new Value(values.get(i + 1))));
        }
        Set<Point> tempSet = new HashSet<>(points);
        if (tempSet.size() != points.size()){
            throw new IllegalArgumentException();
        }
        return points;
    }
}

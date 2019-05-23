package coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointsGenerator {

    public static List<Point> makePoints(String data) {
        List<Point> points = new ArrayList<>();
        List<String> temp = ValueGenerator.splitCoordinates(data);
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

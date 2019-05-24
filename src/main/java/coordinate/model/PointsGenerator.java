package coordinate.model;

import java.util.*;

public class PointsGenerator {

    public static List<Point> makePoints(String coordinates) {
        List<Point> points = new ArrayList<>();
        List<String> cleanedCoordinates = ValueGenerator.splitCoordinates(coordinates);
        Collections.sort(cleanedCoordinates);
        List<String> values = ValueGenerator.splitValue(cleanedCoordinates);

        for (int i = 0; i < values.size(); i = i + 2) {
            points.add(new Point(new Value(values.get(i)), new Value(values.get(i + 1))));
        }

        Set<Point> pointsForTesting = new HashSet<>(points);
        if (pointsForTesting.size() != points.size()){
            throw new IllegalArgumentException();
        }
        return points;
    }
}

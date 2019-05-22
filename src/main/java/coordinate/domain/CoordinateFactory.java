package coordinate.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoordinateFactory {

    public static Coordinate generateCoordinate(List<String> coordinates, List<Point> points) {
        for (String coordinate : coordinates) {
            String[] point = coordinate.split(",");
            generatePoints(points, point[0], point[1]);
        }
        return new Coordinate(points);
    }

    private static List<Point> generatePoints(List<Point> points, String x, String y) {

        if (Collections.indexOfSubList(points, Arrays.asList(new Point(x, y))) == -1) {
            points.add(new Point(x, y));
        }
        return points;
    }
}

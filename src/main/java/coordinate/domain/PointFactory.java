package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointFactory {

    public static PointList generatePointList(List<String> input) {
        List<Point> points = new ArrayList<>();
        for (String inputPoint : input) {
            List<String> splitPoints = splitByComma(inputPoint);
            Point newPoint = new Point(splitPoints.get(0), splitPoints.get(1));
            points.add(newPoint);
        }
        return new PointList(points);
    }

    private static List<String> splitByComma(String inputPoint) {
        return Arrays.asList(inputPoint.split(","));
    }

}

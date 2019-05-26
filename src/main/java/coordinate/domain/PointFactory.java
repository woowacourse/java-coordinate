package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointFactory {

    public static Points generatePoints(List<String> input) {
        List<Point> points = new ArrayList<>();
        for (String inputPoint : input) {
            points.add(convertPoint(inputPoint));
        }
        return new Points(points);
    }

    private static Point convertPoint(String inputPoints) {
        inputPoints = inputPoints.substring(1, inputPoints.length() - 1);
        List<String> splitPoint = splitByComma(inputPoints);
        return new Point(Integer.parseInt(splitPoint.get(0)), Integer.parseInt(splitPoint.get(1)));
    }

    private static List<String> splitByComma(String inputPoint) {
        return Arrays.asList(inputPoint.split(","));
    }

}

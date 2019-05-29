package coordinate.domain;

import coordinate.utils.InputSplitter;

import java.util.ArrayList;
import java.util.List;

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
        List<String> splitPoint = InputSplitter.getSplit(inputPoints, ",");
        return new Point(Integer.parseInt(splitPoint.get(0)), Integer.parseInt(splitPoint.get(1)));
    }

}

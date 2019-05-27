package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class PointsGenerator {
    public static Points generator(Matcher matcher) {
        List<Point> points = new ArrayList<>();
        while (matcher.find()) {
            String[] point = matcher.group().split(",");
            points.add(new Point(Integer.parseInt(point[0]), (Integer.parseInt(point[1]))));
        }
        return new Points(points);
    }
}

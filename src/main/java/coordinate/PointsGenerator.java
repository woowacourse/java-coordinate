package coordinate;

import java.util.ArrayList;
import java.util.List;

public class PointsGenerator {

    public static List<Point> makePoints(String data) {
        List<Point> points = new ArrayList<>();
        List<String> temp = ValueGenerator.splitCoordinates(data);
        List<String> values = ValueGenerator.splitValue(temp);

        for (int i = 0; i < values.size(); i = i + 2) {
            points.add(new Point(new Value(values.get(i)), new Value(values.get(i + 1))));
        }

        return points;
    }
}

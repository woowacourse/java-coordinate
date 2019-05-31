package coordinate.model.creator;

import coordinate.model.Point;
import coordinate.model.Value;
import coordinate.model.Vertices;

import java.util.ArrayList;
import java.util.List;

public class VerticesGenerator {
    public static Vertices makePoints(String data) {
        List<Point> points = new ArrayList<>();
        List<String> values = Splitter.splitValue(data);

        for (int i = 0; i < values.size(); i = i + 2) {
            points.add(new Point(new Value(Integer.parseInt(values.get(i))), new Value(Integer.parseInt(values.get(i + 1)))));
        }

        return new Vertices(points);
    }
}

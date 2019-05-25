package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public Points(List<String> values) {
        for (int i = 0, n = values.size(); i < n; i += 2) {
            points.add(new Point(values.get(i), values.get(i+1)));
        }
    }

    public int getPointCount() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PointsFactory {

    public static Points of(PointFactory pointFactory, List<Integer> numbers) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += 2) {
            points.add(pointFactory.createPoint(numbers.get(i), numbers.get(i + 1)));
        }

        return Points.from(points);
    }
}

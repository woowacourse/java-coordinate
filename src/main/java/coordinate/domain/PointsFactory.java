package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PointsFactory {
    private final PointGenerator generator;

    public PointsFactory(PointGenerator generator) {
        this.generator = generator;
    }

    public static PointsFactory from(PointGenerator generator) {
        return new PointsFactory(generator);
    }

    public Points createFromNumbers(List<Integer> numbers) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += 2) {
            points.add(generator.of(
                    CoordinateNumber.valueOf(numbers.get(i)),
                    CoordinateNumber.valueOf(numbers.get(i + 1))));
        }

        return Points.from(points);
    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {

    public static List<Point> trans(List<Integer> numbers) {
        List<Point> points = getPoints(numbers);
        return points;
    }


    private static List<Point> getPoints(List<Integer> numbers) {
        validate(numbers);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i += 2) {
            points.add(new Point(numbers.get(i), numbers.get(i + 1)));
        }
        return points;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

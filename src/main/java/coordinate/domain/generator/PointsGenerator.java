package coordinate.domain.generator;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsGenerator {
    private static final String REGEX = "(\\([0-9]{1,2},[0-9]{1,2}\\)-)+\\([0-9]{1,2},[0-9]{1,2}\\)";
    private static final String DELIMITER = "-";

    private final String[] coordinates;

    public PointsGenerator(String coordinates) {
        if (!coordinates.matches(REGEX)) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다. ex) (10,10)-(10,10)-(20,8)");
        }
        this.coordinates = Arrays.stream(coordinates.split(DELIMITER))
                .map(s -> s.substring(1, s.length() - 1))
                .toArray(String[]::new);
    }

    public Points generate() {
        List<Point> points = new ArrayList<>();
        for (String coordinate : coordinates) {
            int index = coordinate.indexOf(",");
            int x = Integer.parseInt(coordinate.substring(0, index));
            int y = Integer.parseInt(coordinate.substring(index+1));
            points.add(new Point(x, y));
        }
        return Points.of(points);
    }
}

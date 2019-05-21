package coordinate.domain.generator;

import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsGenerator {
    private static final String REGEX = "\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)";
    private static final String DELIMITER = "-";

    private final String[] coordinates;

    public PointsGenerator(String coordinates) {
        if (!coordinates.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
        this.coordinates = Arrays.stream(coordinates.split(DELIMITER))
                .map(s -> s.substring(1, s.length() - 1))
                .toArray(String[]::new);
    }

    public List<Point> generate() {
        List<Point> points = new ArrayList<>();
        for (String coordinate : coordinates) {
            int index = coordinate.indexOf(",");
            int x = Integer.parseInt(coordinate.substring(0, index));
            int y = Integer.parseInt(coordinate.substring(index+1));
            points.add(new Point(x, y));
        }
        return points;
    }
}

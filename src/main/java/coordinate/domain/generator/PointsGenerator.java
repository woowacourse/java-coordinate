package coordinate.domain.generator;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PointsGenerator {
    private static final String POINTS_INPUT_REGEX = "(\\([0-9]{1,2},[0-9]{1,2}\\)-)+\\([0-9]{1,2},[0-9]{1,2}\\)";
    private static final Pattern POINTS_INPUT_PATTERN = Pattern.compile(POINTS_INPUT_REGEX);
    private static final String COORDINATE_DELIMITER = "-";
    private static final String X_Y_DELIMITER = ",";
    private static final int COORDINATE_BRACE_INDEX = 1;

    public static Points generatePoints(String inputCoordinates) {
        if (!POINTS_INPUT_PATTERN.matcher(inputCoordinates).matches()) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다. ex) (10,10)-(10,10)-(20,8)");
        }

        return generate(splitInputCoordinates(inputCoordinates));
    }

    private static String[] splitInputCoordinates(String inputCoordinates) {
        return Arrays.stream(inputCoordinates.split(COORDINATE_DELIMITER))
                .map(coordinate -> coordinate.substring(COORDINATE_BRACE_INDEX,
                        coordinate.length() - COORDINATE_BRACE_INDEX))
                .toArray(String[]::new);
    }

    private static Points generate(String[] coordinates) {
        List<Point> points = new ArrayList<>();
        for (String coordinate : coordinates) {
            int index = coordinate.indexOf(X_Y_DELIMITER);
            int x = Integer.parseInt(coordinate.substring(0, index));
            int y = Integer.parseInt(coordinate.substring(index + 1));
            points.add(new Point(x, y));
        }
        return Points.of(points);
    }
}

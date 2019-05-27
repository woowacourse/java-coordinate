package coordinate.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerticesFactory {
    private static final String COORDINATE_PATTERN = "^\\((\\d*),(\\d*)\\)$";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 형식으로 입력해 주세요.";

    public static Vertices makeVertices(String userInput) {
        List<Point> points = new ArrayList<>();

        List<String> coordinates = new ArrayList<>(Arrays.asList(userInput.split("-")));
        coordinates.forEach(coordinate -> points.add(makePoint(coordinate)));

        return new Vertices(points);
    }

    private static Point makePoint(String coordinate) {
        Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(coordinate);
        if (!matcher.find()) throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);

        return new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
    }
}

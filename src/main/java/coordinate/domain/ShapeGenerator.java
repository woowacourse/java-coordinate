package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShapeGenerator {
    private static final String INPUT_PATTERN_REGEX = "(\\([0-9]+,[0-9]+\\)-)*\\([0-9]+,[0-9]+\\)";
    private static final String POINT_REGEX = "[0-9]+,[0-9]+";
    private static final int START_POINT_INDEX = 0;
    private static final int END_POINT_INDEX = 1;
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;

    List<Point> points = new ArrayList<>();

    public ShapeGenerator(String input) {
        validatePattern(input);
        initializePoints(input);
    }

    private void validatePattern(String input) {
        if (!input.matches(INPUT_PATTERN_REGEX)) {
            throw new IllegalArgumentException("올바르게 다시 입력해 주세요");
        }
    }

    private void initializePoints(String input) {
        Pattern pattern = Pattern.compile(POINT_REGEX);
        Matcher matcher = pattern.matcher(input);
        String[] pointCoordinate;

        while (matcher.find()) {
            String match = input.substring(matcher.start(), matcher.end());
            pointCoordinate = match.split(",");
            points.add(new Point(new Coordinate(Integer.parseInt(pointCoordinate[X_COORDINATE_INDEX])),
                    new Coordinate(Integer.parseInt(pointCoordinate[Y_COORDINATE_INDEX]))));
        }
    }

    public Line generateLine() {
        if (points.size() < 2) {
            throw new IllegalArgumentException("2개 이상 좌표를 입력해주세요.");
        }
        return new Line(points.get(START_POINT_INDEX), points.get(END_POINT_INDEX));
    }
}

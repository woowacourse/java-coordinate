package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsGenerator {
    private static final String INPUT_PATTERN_REGEX = "(\\([0-9]+,[0-9]+\\)-)*\\([0-9]+,[0-9]+\\)";
    private static final String POINT_REGEX = "[0-9]+,[0-9]+";
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;
    private static final int LINE_POINTS_NUMBER = 2;
    private static final int RECTANGLE_POINTS_NUMBER = 4;

    public static List<Point> generatePoints(String input) {
        validatePattern(input);
        return initializePoints(input);
    }

    private static void validatePattern(String input) {
        if (!input.matches(INPUT_PATTERN_REGEX)) {
            throw new IllegalArgumentException("올바르게 다시 입력해 주세요");
        }
    }

    private static List<Point> initializePoints(String input) {
        List<Point> points = new ArrayList<>();
        Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
        String[] pointCoordinate;

        while (matcher.find()) {
            pointCoordinate = input.substring(matcher.start(), matcher.end()).split(",");
            points.add(new Point(Integer.parseInt(pointCoordinate[X_COORDINATE_INDEX]),
                    Integer.parseInt(pointCoordinate[Y_COORDINATE_INDEX])));
        }

        validatePointsNumber(points.size());
        return points;
    }

    private static void validatePointsNumber(int size) {
        if (size < LINE_POINTS_NUMBER || size > RECTANGLE_POINTS_NUMBER) {
            throw new IllegalArgumentException("좌표의 개수는 2개 이상, 4개 이하여야 합니다.");
        }
    }
}

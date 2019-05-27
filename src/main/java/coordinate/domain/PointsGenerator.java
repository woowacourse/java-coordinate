package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PointsGenerator {
    private static final String POINT_RANGE = "[1-2]?[0-9]{1}";
    private static final String POINT_FORMAT = String.format("(%s,%s)", POINT_RANGE, POINT_RANGE);
    private static final String POINTS_FORMAT = String.format("^\\(%s\\)(?:-\\(%S\\)){1,3}?$", POINT_FORMAT, POINT_FORMAT);
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    public static Points of(String input) {
        validPointsFormat(input);
        return new Points(convertPoints(input));
    }

    private static void validPointsFormat(String input) {
        Pattern pointsFormatPattern = Pattern.compile(POINTS_FORMAT);
        Matcher pointsFormatMatcher = pointsFormatPattern.matcher(input);

        if (!pointsFormatMatcher.find()) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
    }

    private static List<Point> convertPoints(String input) {
        List<Point> points = new ArrayList<>();
        Pattern pointFormatPattern = Pattern.compile(POINT_FORMAT);
        Matcher pointFormatMatcher = pointFormatPattern.matcher(input);
        while (pointFormatMatcher.find()) {
            points.add(convertPoint(pointFormatMatcher.group()));
        }
        return points;
    }

    private static Point convertPoint(String input) {
        List<Integer> point = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Point(new Scalar(point.get(FIRST_POINT)), new Scalar(point.get(SECOND_POINT)));
    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsGenerator {

    private static final String POINTS_REGEX = "\\([0-9]{1,2},[0-9]{1,2}\\)(?:-\\([0-9]{1,2},[0-9]{1,2}\\)){1,3}";
    private static final String POINT_REGEX = "\\(([0-9]{1,2}),([0-9]{1,2})\\)";
    private static final String SEPARATOR = "-";
    private static final int X_COORDINATE = 1;
    private static final int Y_COORDINATE = 2;

    public static Points generate(String formula) {
        if (!Pattern.matches(POINTS_REGEX, formula)) {
            throw new IllegalArgumentException("잘못된 식입니다.");
        }

        return generatePoints(formula);
    }

    private static Points generatePoints(String formula) {
        List<Point> points = new ArrayList<>();
        for (String point : formula.split(SEPARATOR)) {
            points.add(generatePoint(point));
        }
        return new Points(points);
    }

    private static Point generatePoint(String point) {
        Matcher matcher = Pattern.compile(POINT_REGEX).matcher(point);
        if (matcher.find()) {
            return new Point(Integer.parseInt(matcher.group(X_COORDINATE)),
                    Integer.parseInt(matcher.group(Y_COORDINATE)));
        }
        throw new IllegalArgumentException("잘못된 좌표입니다.");
    }
}

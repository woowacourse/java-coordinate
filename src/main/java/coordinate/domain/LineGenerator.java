package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineGenerator {

    private static final String POINTS_REGEX = "\\(([0-9]+),([0-9]+)\\)-\\(([0-9]+),([0-9]+)\\)";

    public static Line generate(String formula) {
        Matcher matcher = Pattern.compile(POINTS_REGEX).matcher(formula);
        if (matcher.find()) {
            return generateLine(matcher);
        }
        throw new IllegalArgumentException("잘못된 식입니다.");
    }

    private static Line generateLine(Matcher matcher) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= matcher.groupCount(); i += 2) {
            points.add(generatePoint(matcher.group(i), matcher.group(i + 1)));
        }
        return new Line(points.get(0), points.get(1));
    }

    private static Point generatePoint(String x, String y) {
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }
}

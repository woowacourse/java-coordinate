package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FigureGenerator {
    private static final String POINTS_REGEX = "\\([0-9]{1,2},[0-9]{1,2}\\)(?:-\\([0-9]{1,2},[0-9]{1,2}\\)){1,3}";
    private static final String POINT_REGEX = "\\(([0-9]{1,2}),([0-9]{1,2})\\)";
    private static final String SEPARATOR = "-";

    public static Figure generate(String formula) {
        if (!Pattern.matches(POINTS_REGEX, formula)) {
            throw new IllegalArgumentException("잘못된 식입니다.");
        }

        Points points = generatePoints(formula);
        return generateFigure(points);
    }

    private static Figure generateFigure(Points points) {
        if (points.size() == 2) {
            return new Line(points);
        }
        if (points.size() == 3) {
            return new Triangle(points);
        }
        if (points.size() == 4) {
            return new Rectangle(points);
        }
        throw new IllegalArgumentException("도형을 만들 수 없습니다.");
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
            return new Point(Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)));
        }
        throw new IllegalArgumentException("잘못된 좌표입니다.");
    }
}

package coordinate.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Points {
    private static final String POINT_SEPARATOR = "-";
    private static final String COORDINATE_SEPARATOR = ",";
    private static final String FRONT_COORDINATE_WRAPPER = "(";
    private static final String BACK_COORDINATE_WRAPPER = ")";
    private static final int PAIR = 2;
    private static final int BASE = 0;

    List<Point> points;

    private Points(List<Point> points) {
        validateDuplicate(points);
        this.points = points;
    }

    private void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }

    public static Points of(List<Point> points) {
        return new Points(points);
    }

    public static Points of(String inputString) {
        return new Points(parse(inputString));
    }

    private static List<Point> parse(String rawInput) {
        List<Point> points = new ArrayList<>();
        String[] tuples = rawInput.split(POINT_SEPARATOR);

        for (String tuple : tuples) {
            validateBetweenBrackets(tuple);
            List<Integer> coordinates = new ArrayList<>(splitToCoordinates(tuple));
            points.add(new Point(coordinates));
        }
        return points;
    }

    private static void validateBetweenBrackets(String tuple) {
        if (!tuple.startsWith(FRONT_COORDINATE_WRAPPER)
                || !tuple.endsWith(BACK_COORDINATE_WRAPPER)) {
            throw new IllegalArgumentException("좌표들은 소괄호로 둘러 쌓여 있어야 합니다.");
        }
    }

    private static List<Integer> splitToCoordinates(String tuple) {
        return Arrays.stream(stripBrackets(tuple)
                .split(COORDINATE_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String stripBrackets(String tuple) {
        int startIndex = tuple.indexOf(FRONT_COORDINATE_WRAPPER) + FRONT_COORDINATE_WRAPPER.length();
        int lastIndex = tuple.lastIndexOf(BACK_COORDINATE_WRAPPER);

        return tuple.substring(startIndex, lastIndex);
    }

    Integer size() {
        return points.size();
    }

    List<Point> getAllPoints() {
        return points;
    }

    boolean hasXPairOf(Point point) {
        Points pointsHavingSameXCoordinate = findXPairOf(point);

        return pointsHavingSameXCoordinate.size() == PAIR;
    }

    Points findXPairOf(Point point) {
        return new Points(points.stream()
                .filter(p -> p.matchX(point))
                .collect(Collectors.toList()));
    }

    boolean hasYPairOf(Point point) {
        Points pointsHavingSameYCoordinate = findYPairOf(point);

        return pointsHavingSameYCoordinate.size() == PAIR;
    }

    Points findYPairOf(Point point) {
        return new Points(points.stream()
                .filter(p -> p.matchY(point))
                .collect(Collectors.toList()));
    }

    Point getBasePoint() {
        return points.get(BASE);
    }

    Point get(int index) {
        return points.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

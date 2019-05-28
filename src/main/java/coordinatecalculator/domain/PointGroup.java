package coordinatecalculator.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointGroup {
    private static final String DELIMITER = "-";
    private static final int POINT_X = 1;
    private static final int POINT_Y = 2;
    private static final String ERROR_NOT_INTEGER_POINT = "x 또는 y가 정수가 아닙니다.";
    private static final String ERROR_INPUT_PATTERN = "'-'로 구분하여 (x1,y1)-(x2, y2)... 형태로 입력하세요.";
    private static final String ERROR_DUPLICATED_POINTS = "입력한 좌표가 중복됩니다.";
    private static final String ERROR_EMPTY_INPUT = "입력이 없습니다.";

    private static Pattern pattern = Pattern.compile("\\((.*),(.*)\\)");

    private List<Point> points;

    public PointGroup(String input) {
        List<Point> unprocessedPoints = new ArrayList<>();

        isEmpty(input);
        fillUnverifiedPoints(input, unprocessedPoints);
        checkDuplicatePoints(unprocessedPoints);
        Collections.sort(unprocessedPoints);

        this.points = unprocessedPoints;
    }

    private static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException(ERROR_EMPTY_INPUT);
        }
    }

    private static void fillUnverifiedPoints(String input, List<Point> points) {
        String[] separatedPoints = input.split(DELIMITER);
        for (String separatedPoint : separatedPoints) {
            points.add(makePoint(separatedPoint));
        }
    }

    private static Point makePoint(String separatedPoint) {
        Matcher matcher = pattern.matcher(separatedPoint);

        checkMatchPointPattern(matcher);

        return Point.of(getCoordinate(matcher, POINT_X), getCoordinate(matcher, POINT_Y));
    }

    private static void checkMatchPointPattern(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_INPUT_PATTERN);
        }
    }

    private static int getCoordinate(Matcher matcher, int coordinate) {
        return toInts(matcher.group(coordinate).trim());
    }

    private static int toInts(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(ERROR_NOT_INTEGER_POINT);
        }
    }

    private static void checkDuplicatePoints(final List<Point> points) {
        if (isDuplicatePoints(points)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_POINTS);
        }
    }

    private static boolean isDuplicatePoints(final List<Point> points) {
        Set<Point> uniquePoints = new HashSet<>(points);
        return uniquePoints.size() != points.size();
    }

    List<Point> getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PointGroup that = (PointGroup) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

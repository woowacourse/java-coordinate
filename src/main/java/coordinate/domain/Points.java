package coordinate.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Points {
    private static final int MIN_POINTS = 2;
    private static final int MAX_POINTS = 8;
    private static final int REMAINDER_NUMBER = 2;
    private static final int ZERO = 0;

    private final List<Point> points;

    public Points(String inputPoints) {
        this(createPoints(convertCoordinate(inputPoints)));
    }

    public Points(List<Point> points) {
        if (isDuplicate(points)) {
            throw new IllegalArgumentException("중복된 좌표가 존재합니다");
        }
        Collections.sort(points);
        this.points = points;
    }

    public static List<Point> createPoints(List<Integer> coordinateValue) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < coordinateValue.size(); i += 2) {
            int axisX = coordinateValue.get(i);
            int axisY = coordinateValue.get(i + 1);
            points.add(new Point(axisX, axisY));
        }
        return points;
    }

    public static List<Integer> convertCoordinate(String inputPoints) {
        List<Integer> coordinateValue = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(inputPoints);
        while (matcher.find()) {
            String pointLine = matcher.group()
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            coordinateValue.addAll(convertPoints(pointLine));
        }
        checkPointSize(coordinateValue);
        return coordinateValue;
    }

    private static List<Integer> convertPoints(String str) {
        try {
            List<Integer> convertPoints = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(toList());
            return convertPoints;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 들어있습니다");
        }
    }

    private static void checkPointSize(List<Integer> coordinate) {
        int coordinateSize = coordinate.size();
        if (coordinateSize % REMAINDER_NUMBER != ZERO || coordinateSize < MIN_POINTS || coordinateSize > MAX_POINTS) {
            throw new IllegalArgumentException("유효한 값만 입력해주세요");
        }
    }

    boolean isDuplicate(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        return set.size() != points.size();
    }

    public int size() {
        return points.size();
    }

    public Point get(int index) {
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

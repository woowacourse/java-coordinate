package coordinate.domain;

import coordinate.domain.validator.PointsValidator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Points {
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

    private static List<Integer> convertCoordinate(String inputPoints) {
        List<Integer> coordinateValue = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(inputPoints);
        while (matcher.find()) {
            String pointLine = matcher.group().replaceAll("\\(", "").replaceAll("\\)", "");
            coordinateValue.addAll(PointsValidator.convertPoints(pointLine));
        }
        PointsValidator.checkPointSize(coordinateValue);
        return coordinateValue;
    }

    private static List<Point> createPoints(List<Integer> coordinateValue) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < coordinateValue.size(); i += 2) {
            int axisX = coordinateValue.get(i);
            int axisY = coordinateValue.get(i + 1);
            points.add(new Point(axisX, axisY));
        }
        return points;
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

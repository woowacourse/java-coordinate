package coordinate.domain;

import java.util.*;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {
    private static Map<Integer, Function<List<Point>, Figure>> methodMapping = new HashMap<>();

    static {
        methodMapping.put(4, (points) -> getRectangle(points));
        methodMapping.put(3, (points) -> getTriangle(points));
        methodMapping.put(2, (points) -> getLine(points));
    }

    @Override
    public Figure create(List<Point> points) {
        if (2 <= points.size() && points.size() <= 4) {
            return methodMapping.get(points.size()).apply(points);
        }
        throw new IllegalArgumentException("지원하지 않는 도형입니다.");
    }

    private static Figure getRectangle(List<Point> points) {
        points = sort(points);
        Lines lines = getLinesFromPoints(points);
        return new Rectangle(lines);
    }

    /**
     * 유저가 지그재그 순서로 선을 입력했을 경우를 대비해 올바르게 정렬하는 메서드
     */
    private static List<Point> sort(List<Point> points) {
        List<Point> sortedPoints = new ArrayList<>();
        Collections.sort(points);
        sortedPoints.add(points.get(0));
        sortedPoints.add(points.get(1));
        sortedPoints.add(points.get(3));
        sortedPoints.add(points.get(2));
        return sortedPoints;
    }

    private static Figure getTriangle(List<Point> points) {
        Lines lines = getLinesFromPoints(points);
        return new Triangle(lines);
    }

    private static Figure getLine(List<Point> points) {
        return new Line(points.get(0), points.get(1));
    }

    private static Lines getLinesFromPoints(List<Point> points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.get(i), points.get((i + 1) % points.size())));
        }
        return new Lines(lines);
    }
}

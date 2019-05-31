package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RectangleCreator extends PolygonCreator {
    /**
     * 유저가 지그재그 순서로 선을 입력했을 경우를 대비해 올바르게 정렬하는 메서드
     */
    private static List<Point> sort(List<Point> points) {
        List<Point> sortedPoints = new ArrayList<>();
        Collections.sort(points);
        sortedPoints.addAll(Arrays.asList(points.get(0), points.get(1), points.get(3), points.get(2)));
        return sortedPoints;
    }

    @Override
    public Figure create(List<Point> points) {
        points = sort(points);
        Lines lines = getLinesFromPoints(points);
        return new Rectangle(lines);
    }
}
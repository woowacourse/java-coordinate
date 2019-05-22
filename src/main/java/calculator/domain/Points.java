package calculator.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Points implements Iterable<Point>{
    private static final String EX_DUPLICATED_POINT_MESSAGE = "위치가 같은 점(point)이 존재합니다.";
    public static final String EX_MAX_POINTS_COUNT_MESSAGE = "4개 이하의 좌표를 입력해주세요.";
    public static final int MAX_POINTS = 4;
    private final List<Point> points;

    /**
     * 생성자
     */
    public Points()  {
        this.points = new ArrayList<>();
    }

    /**
     * Point 추가
     * <br> 중복된 Point 추가 시 예외 발생
     *
     * @param point 추가할 Point
     * @throws IllegalArgumentException
     */
    public void add(Point point) {
        checkDuplication(point);
        checkMaxPoints();

        points.add(point);
    }

    private void checkDuplication(Point point) {
        if (points.contains(point)) {
            throw new IllegalArgumentException(EX_DUPLICATED_POINT_MESSAGE);
        }
    }

    private void checkMaxPoints() {
        if (points.size() >= MAX_POINTS) {
            throw new IllegalArgumentException(EX_MAX_POINTS_COUNT_MESSAGE);
        }
    }

    /**
     * 크기 반환
     *
     * @return points.size
     */
    public int size() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
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

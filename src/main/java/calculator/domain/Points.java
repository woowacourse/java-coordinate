package calculator.domain;

import java.util.*;

/**
 * Point 들을 모아놓은 class
 * <br> 중복된 좌표가 있는지 확인
 *
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Points implements Iterable<Point> {
    private static final String EX_DUPLICATED_COORDINATES_MESSAGE = "위치가 같은 점(point)이 존재합니다.";
    private final List<Point> points;

    /**
     * 생성자
     */
    public Points() {
        this.points = new ArrayList<>();
    }

    public Points(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    /**
     * Point 추가
     * <br> 중복된 Point 추가 시 예외 발생
     *
     * @param point 추가할 Point
     * @throws IllegalArgumentException
     */
    public Points add(Point point) {
        checkDuplication(point);
        points.add(point);
        Collections.sort(points);
        return new Points(points);
    }

    private void checkDuplication(Point point) {
        if (points.contains(point)) {
            throw new IllegalArgumentException(EX_DUPLICATED_COORDINATES_MESSAGE);
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

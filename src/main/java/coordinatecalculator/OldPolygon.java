package coordinatecalculator;

import java.util.*;
import java.util.stream.Collectors;

/* 예전 코드. 새로운 추상 클래스를 만들기 위하여 이름을 바꿨다. 현재 사용 중지. */
class OldPolygon implements Figure {
    private List<Point> points;

    OldPolygon(Point... points) throws IllegalArgumentException {
        if (points.length < Figure.MINIMUM_POINTS_COUNT) {
            throw new IllegalArgumentException(ERROR_POINTS_INSUFFICIENT);
        }
        this.points = Arrays.asList(points);
        checkDuplicate(this.points);
        this.points = sortClosedPath(this.points);
    }

    /* 2차원 직교좌표 평면상에서 임의의 다각형 넓이를 구하는 일반화된 방법인
     * "신발끈 공식"(가우스의 면적 공식)을 구현하였다.
     * 참고: https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D */
    @Override
    public double area() {
        int x;
        int y;
        int sum = 0;
        int length = points.size();

        for (int i = 0; i < length; i++) {
            x = points.get(i).getX();
            y = points.get(nextNumber(i, length)).getY();
            sum += x * y;
        }

        for (int i = 0; i < length; i++) {
            x = points.get(nextNumber(i, length)).getX();
            y = points.get(i).getY();
            sum -= x * y;
        }

        return (double) (Math.abs(sum)) / 2;
    }

    private int nextNumber(int number, int max) {
        return (number + 1) % max;
    }

    private void checkDuplicate(List<Point> points) throws IllegalArgumentException {
        Set<Point> set = new HashSet<>();
        for (Point p : points) {
            if (!set.add(p)) { // Set은 중복된 객체를 넣으면 false를 반환한다.
                throw new IllegalArgumentException(ERROR_POINTS_DUPLICATE);
            }
        }
    }

    /* 주어진 점들을 반시계 방향 폐곡선을 이루는 형태로 정렬하기 위한 메소드.
     * 일부 상황에서 신발끈 공식의 올바른 적용을 위해 필요하다.
     * 참고: https://stackoverflow.com/a/20623817 */
    private List<Point> sortClosedPath(final List<Point> points) {
        points.sort(Point::compareTo);
        final int FIRST = 0;
        final int LAST = points.size() - 1;
        final Segment bisectLine = new Segment(points.get(FIRST), points.get(LAST));
        final List<Point> increaseX = points.stream()
                .filter(p -> bisectLine.aboveOrBelowPoint(p) == Segment.bisect.ABOVE)
                .collect(Collectors.toList());
        final List<Point> decreaseX = points.stream()
                .filter(p -> bisectLine.aboveOrBelowPoint(p) == Segment.bisect.BELOW)
                .collect(Collectors.toList());
        increaseX.sort(Point::compareTo);
        decreaseX.sort(Point::compareToReverse);
        final List<Point> temp = new ArrayList<>();
        temp.add(bisectLine.getStartPoint());
        temp.addAll(increaseX);
        temp.add(bisectLine.getEndPoint());
        temp.addAll(decreaseX);
        return temp;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final OldPolygon polygon = (OldPolygon) another;
        return points.equals(polygon.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

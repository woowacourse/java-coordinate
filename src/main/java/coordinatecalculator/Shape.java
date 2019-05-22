package coordinatecalculator;

import java.util.*;
import java.util.stream.Collectors;

class Shape implements Figure {
    private static final String ERROR_POINTS_INSUFFICIENT
            = "점의 개수가 도형을 만들기에 모자랍니다.";
    private static final String ERROR_POINTS_DUPLICATE
            = "입력된 점의 좌표가 중복됩니다.";
    private List<Point> points;

    Shape(Point... points) throws IllegalArgumentException {
        if (points.length < Figure.MINIMUM_POINTS_COUNT) {
            throw new IllegalArgumentException(ERROR_POINTS_INSUFFICIENT);
        }
        this.points = Arrays.asList(points);
        checkDuplicate();
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

    private void checkDuplicate() throws IllegalArgumentException {
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
        final Point leftMost = points.get(FIRST);
        final Point rightMost = points.get(LAST);
        final List<Point> increaseX = points.stream()
                .filter(p -> bisectLine.aboveOrBelow(p, leftMost, rightMost) == bisectLine.ABOVE)
                .collect(Collectors.toList());
        final List<Point> decreaseX = points.stream()
                .filter(p -> bisectLine.aboveOrBelow(p, leftMost, rightMost) == bisectLine.BELOW)
                .collect(Collectors.toList());
        increaseX.sort(Point::compareTo);
        decreaseX.sort(Point::compareToReverse);
        final List<Point> temp = new ArrayList<>();
        temp.add(leftMost);
        temp.addAll(increaseX);
        temp.add(rightMost);
        temp.addAll(decreaseX);
        return temp;
    }

    /* 2개의 점으로 이루어진 선과 비교하여, 주어진 점이 선의 위에 있는지
     * 아래에 있는지를 판별한다. 이는 폐곡선 작성에 필요하다.
     * 참고: https://stackoverflow.com/questions/3838319 */
    private enum bisectLine {
        ABOVE, BELOW, SAME;

        static bisectLine aboveOrBelow(Point point, Point leftMost, Point rightMost) {
            Point vector1 = new Point(rightMost.getX() - leftMost.getX(), rightMost.getY() - leftMost.getY());
            Point vector2 = new Point(rightMost.getX() - point.getX(), rightMost.getY() - point.getY());
            int crossProduct = (vector1.getX() * vector2.getY()) - (vector1.getY() * vector2.getX());
            return crossProduct > 0 ? ABOVE : crossProduct < 0 ? BELOW : SAME;
        }
    }
}

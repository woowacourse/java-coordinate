package coordinatecalculator;

import java.util.Comparator;
import java.util.Objects;

class Line implements Comparable<Line> {
    private Point start;
    private Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStartPoint() {
        return this.start;
    }

    public Point getEndPoint() {
        return this.end;
    }

    public double getLength() {
        return this.start.getDistance(this.end);
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Line line = (Line) another;
        return start.equals(line.start) &&
                end.equals(line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Line another) {
        return Comparator
                .comparing(Line::getStartPoint)
                .thenComparing(Line::getEndPoint)
                .compare(this, another);
    }

    @Override
    public String toString() {
        return "Line {start: "
                + this.start.toString()
                + ", end: "
                + this.end.toString()
                + ", length: "
                + this.getLength() + "}";
    }

    /* 선과 주어진 점을 비교하여, 주어진 점이 선의 위에 있는지
     * 아래에 있는지를 판별한다. 이는 폐곡선 작성에 필요하다.
     * 참고: https://stackoverflow.com/questions/3838319 */
    bisect aboveOrBelowPoint(Point point) {
        Point leftMost = this.start;
        Point rightMost = this.end;
        if (rightMost.compareTo(leftMost) < 0) {
            Point temp = rightMost; // 자바에서는 객체 스왑하기가 까다로워 이게 훨씬 짧다.
            rightMost = leftMost;
            leftMost = temp;
        }
        Point vector1 = new Point(leftMost.getX() - rightMost.getX(), leftMost.getY() - rightMost.getY());
        Point vector2 = new Point(leftMost.getX() - point.getX(), leftMost.getY() - point.getY());
        int crossProduct = (vector1.getX() * vector2.getY()) - (vector1.getY() * vector2.getX());
        return crossProduct > 0 ? bisect.ABOVE : crossProduct < 0 ? bisect.BELOW : bisect.SAME;
    }

    enum bisect {
        ABOVE, BELOW, SAME
    }
}

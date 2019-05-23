package coordinatecalculator;

import java.util.Comparator;
import java.util.Objects;

class Segment implements Comparable<Segment> {
    private Point start;
    private Point end;

    Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    Point getStartPoint() {
        return this.start;
    }

    Point getEndPoint() {
        return this.end;
    }

    double getLength() {
        return this.start.getDistance(this.end);
    }

    /* 선의 기울기를 알아내는 메소드.
     * 참고: https://www.geeksforgeeks.org/orientation-3-ordered-points/ */
    double getSlope() {
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Segment segment = (Segment) another;
        return start.equals(segment.start) &&
                end.equals(segment.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Segment another) {
        return Comparator
                .comparing(Segment::getStartPoint)
                .thenComparing(Segment::getEndPoint)
                .compare(this, another);
    }

    int compareToSlope(Segment another) {
        return Comparator
                .comparingDouble(Segment::getSlope)
                .compare(this, another);
    }

    @Override
    public String toString() {
        return "Segment: {start: "
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

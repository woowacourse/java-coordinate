package coordinate.domain.figure;

import coordinate.domain.nonefigure.Point;
import coordinate.domain.nonefigure.PointGroup;
import coordinate.domain.nonefigure.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class Line extends Figure implements Comparable<Line> {
    private static final int POINT_COUNT = 2;
    private Point startPoint;
    private Point endPoint;

    public Line(PointGroup points) {
        super(points, POINT_COUNT);
        this.startPoint = points.getPoint(0);
        this.endPoint = points.getPoint(1);
    }

    public Line(Point startPoint, Point endPoint) {
        super(new PointGroup(new ArrayList<Point>(Arrays.asList(startPoint, endPoint))), 2);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }


    public Vector toVector() {
        Vector vector = new Vector(startPoint.getX() - endPoint.getX(),
                startPoint.getY() - endPoint.getY());
        return vector;
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("라인은 두 점으로 구성하세요");
        }
    }

    @Override
    public double size() {
        double length = Math.pow(startPoint.getX() - endPoint.getX(), 2);
        length += Math.pow(startPoint.getY() - endPoint.getY(), 2);

        return Math.sqrt(length);
    }

    @Override
    public int compareTo(Line anotherLine) {
        if (this.size() < anotherLine.size()) {
            return -1;
        }
        if (this.size() > anotherLine.size()) {
            return 1;
        }
        return 0;
    }


}

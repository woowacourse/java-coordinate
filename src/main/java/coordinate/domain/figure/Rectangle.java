package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;
import coordinate.domain.nonefigure.Vector;

import java.util.*;

public class Rectangle extends Figure implements AreaCalculable {
    private static final int POINT_COUNT = 4;

    public Rectangle(PointGroup points) {
        super(points, POINT_COUNT);
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("직사각형은 4개의 점으로 이루어져야합니다.");
        }
        if (!checkRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean checkRectangle(PointGroup points) {
        List<Line> lines = new ArrayList();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.getPoint(i), points.getPoint((i+1)%points.size())));
        }
        List<Vector> vectors = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            vectors.add(lines.get(i).toVector());
        }
        for (int i = 0; i < vectors.size(); i++) {
            int xProduct = vectors.get(i).getX() * vectors.get((i+1)%points.size()).getX();
            int yProduct = vectors.get(i).getY() * vectors.get((i+1)%points.size()).getY();
            int innerProduct = xProduct + yProduct;
            if (innerProduct != 0) {
                return false;
            }
        }
        return true;
    }

    public double area() {
        PointGroup points = getPoints();
        double area = 1;
        List<Line> lines = new ArrayList();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.getPoint(i), points.getPoint((i+1)%points.size())));
        }
        for (Line line : lines) {
            area = line.length() * area;
        }
        return Math.sqrt(area);
    }

    @Override
    public String toString() {
        return "사각형";
    }
}

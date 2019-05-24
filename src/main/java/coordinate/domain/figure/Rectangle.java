package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;
import coordinate.domain.nonefigure.Vector;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure implements SizeCalculable {
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
        List<Line> lines = points.getLines();
        List<Vector> vectors = new ArrayList<>();
        lines.forEach(line -> vectors.add(line.toVector()));

        return checkDegreesAreAll90(points, vectors);
    }

    private boolean checkDegreesAreAll90(PointGroup points, List<Vector> vectors) {
        for (int i = 0; i < vectors.size(); i++) {
            int xProduct = vectors.get(i).getX() * vectors.get((i + 1) % points.size()).getX();
            int yProduct = vectors.get(i).getY() * vectors.get((i + 1) % points.size()).getY();
            int innerProduct = xProduct + yProduct;
            if (innerProduct != 0) {
                return false;
            }
        }
        return true;
    }

    public double size() {
        PointGroup points = getPoints();
        double area = 1;
        List<Line> lines = points.getLines();
        for (Line line : lines) {
            area = line.size() * area;
        }
        return Math.sqrt(area);
    }

    @Override
    public String toString() {
        return "사각형";
    }
}

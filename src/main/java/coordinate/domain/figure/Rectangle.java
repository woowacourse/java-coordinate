package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;
import coordinate.domain.nonefigure.Vector;
import coordinate.domain.nonefigure.VectorGroup;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure {
    private static final int POINT_COUNT = 4;

    public Rectangle(PointGroup points) {
        super(points, POINT_COUNT);
    }

    private boolean checkRectangle(PointGroup points) {
        List<Line> lines = points.getLines();
        VectorGroup vectors = VectorGroup.create(lines);

        return vectors.checkDegreesAreAll90();
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
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("직사각형은 4개의 점으로 이루어져야합니다.");
        }
        if (!checkRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return "사각형";
    }
}

package coordinate.domain;

import java.util.List;

public class TriangleCreator extends PolygonCreator {
    @Override
    public Figure create(List<Point> points) {
        Lines lines = getLinesFromPoints(points);
        return new Triangle(lines);
    }
}
package coordinate.model;

import java.util.HashSet;
import java.util.List;

public class Vertices {
    private List<Point> vertices;

    public Vertices(List<Point> vertices) {
        checkSamePoint(vertices);
        this.vertices = vertices;
        sortVertices(vertices.get(0));
    }

    private void checkSamePoint(List<Point> vertices) {
        if (vertices.size() != new HashSet<>(vertices).size()) {
            throw new IllegalArgumentException();
        }
    }

    private void sortVertices(Point standard) {
        vertices.sort((o1, o2) -> {
            double distanceStandardAndPoint1 = standard.howFar(o1);
            double distanceStandardAndPoint2 = standard.howFar(o2);

            return ((Comparable) distanceStandardAndPoint1).compareTo(distanceStandardAndPoint2);
        });
    }

    int getSize() {
        return vertices.size();
    }

    public List<Point> getPoints() {
        return vertices;
    }

    Point getStandardPoint() {
        return vertices.get(0);
    }

    Point getTheFarthestPoint() {
        return vertices.get(vertices.size() - 1);
    }

    double calculatorDistance(int firstPoint, int secondPoint) {
        return vertices.get(firstPoint).howFar(vertices.get(secondPoint));
    }

    Vector getVector(int firstPoint, int secondPoint) {
        return new Vector(vertices.get(firstPoint), vertices.get(secondPoint));
    }
}

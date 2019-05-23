package coordinatecalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Rectangle extends Polygon {
    private List<Triangle> triangles = new ArrayList<>();

    Rectangle(Point a, Point b, Point c, Point d) {
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);

        // 순서 재배열 및 삼각형 2개로 나누기
        points.sort(Point::compareTo);
        Collections.swap(points, points.size() - 1, points.size() - 2);
        segments = makeSegment(this.points);
        splitTriangles();
    }

    @Override
    public double area() {
        double result = 0;
        for (Triangle triangle : triangles) {
            result += triangle.area();
        }
        return result;
    }

    private void splitTriangles() {
        Point left = points.get(0);
        Point upper = points.get(1);
        Point right = points.get(2);
        Point under = points.get(3);
        triangles.add(new Triangle(left, right, upper));
        triangles.add(new Triangle(left, right, under));
    }
}

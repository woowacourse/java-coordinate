package coordinatecalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Rectangle extends Polygon {
    private List<Triangle> triangles = new ArrayList<>();

    Rectangle(List<Point> points) {
        super(points);

        // 순서 재배열 및 삼각형 2개로 나누기
        points.sort(Point::compareTo);
        Collections.swap(points, points.size() - 1, points.size() - 2);
        lines = makeSegment(this.points);
        splitTriangles();
    }

    public static Rectangle of(Point p1, Point p2, Point p3, Point p4) {
        return new Rectangle(Arrays.asList(p1, p2, p3, p4));
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.###");
        return "사각형의 넓이는 "
                + format.format(area())
                + "입니다.";
    }

    @Override
    public double area() {
        double result = 0;
        for (Triangle triangle : triangles) {
            result += triangle.area();
        }
        return result;
    }

    @Override
    public int getPointsCount() {
        return 4;
    }

    private void splitTriangles() {
        Point left = points.get(0);
        Point upper = points.get(1);
        Point right = points.get(2);
        Point under = points.get(3);
        triangles.add(new Triangle(Arrays.asList(left, right, upper)));
        triangles.add(new Triangle(Arrays.asList(left, right, under)));
    }
}

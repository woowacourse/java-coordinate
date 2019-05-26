package coordinate.domain;

import java.util.Arrays;

public class Rectangle extends Figure {
    public Rectangle(Points points) {
        super(points);
        if (points.size() != 4) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (!isRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    static boolean isRectangle(Points points) {
        Point pivPoint = points.get(0);
        Point rightPoint = points.get(1);
        Point leftPoint = points.get(2);
        Point crossPoint = points.get(3);

        Point rightVector = pivPoint.calVector(rightPoint);
        Point leftVector = pivPoint.calVector(leftPoint);
        if (rightVector.calDotProduct(leftVector) != 0) {
            return false;
        }
        if (!pivPoint.calCrossPoint(rightVector, leftVector).equals(crossPoint)) {
            return false;
        }
        return true;
    }

    public double calculateFigure() {
        double width = new Line(new Points(Arrays.asList(points.get(0), points.get(1)))).calculateFigure();
        double height = new Line(new Points(Arrays.asList(points.get(0), points.get(2)))).calculateFigure();
        return width * height;
    }

    @Override
    public String toString() {
        return "사각형 넓이는 ";
    }
}

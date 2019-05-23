package coordinate.domain;

public class Rectangle {
    private final Points points;

    public Rectangle(Points points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (isRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
        this.points = points;
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

    public double calArea() {
        return 0.0;
    }
}

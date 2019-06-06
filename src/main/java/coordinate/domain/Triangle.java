package coordinate.domain;

public class Triangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 3;

    Triangle(Points points) {
        super(points, VALID_LENGTH_OF_POINTS);
        validateTrianglePoints();
    }

    private void validateTrianglePoints() {
        if (area() == 0) {
            throw new IllegalThreadStateException("세 점이 한 직선상에 있습니다.");
        }
    }

    @Override
    public double area() {
        double s = points.getSForTriangle();
        return Math.pow(s * (s - points.length(0 ,1)) * (s - points.length(0 ,2)) * (s - points.length(1 ,2))
                , 0.5);
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area();
    }
}

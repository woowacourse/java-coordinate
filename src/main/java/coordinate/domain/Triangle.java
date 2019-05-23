package coordinate.domain;

import java.util.Objects;

public class Triangle extends Figure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int THIRD_POINT = 2;
    private static final int ROUNDING_CRITERION = 1000;
    private static final int ZERO_AREA = 0;

    public Triangle(Points points) {
        super("삼각형의 넓이는 : ", points);
        checkValidCoordinate();
    }

    private void checkValidCoordinate() {
        if (calculateResult() == ZERO_AREA) {
            throw new IllegalArgumentException("삼각형을 만들 수 없습니다.");
        }
    }

    /**
     * 헤론의 공식을 활용한 삼각형 넓이 계산
     */
    @Override
    public double calculateResult() {
        double a = points.getPoints(FIRST_POINT).calculateDistance(points.getPoints(SECOND_POINT));
        double b = points.getPoints(FIRST_POINT).calculateDistance(points.getPoints(THIRD_POINT));
        double c = points.getPoints(SECOND_POINT).calculateDistance(points.getPoints(THIRD_POINT));
        double s = (a + b + c) / 2;
        return Math.round((Math.sqrt(s * (s - a) * (s - b) * (s - c)) * ROUNDING_CRITERION)) / ROUNDING_CRITERION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

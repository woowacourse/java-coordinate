package coordinate.model;

import coordinate.model.framework.Shape;

import java.util.List;

public class Triangle extends Shape {
        public Triangle(List<Point> points) {
                super(points);
                checkIsLine(this.points);
        }

        private void checkIsLine(Points points) {
                if (points.getIncline(FIRST_POINT, SECOND_POINT)
                    == points.getIncline(SECOND_POINT, THIRD_POINT)) {
                        throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
                }
        }

        @Override
        public double getScore() {
                return getTriangleArea(points.getDistance(FIRST_POINT, SECOND_POINT),
                    points.getDistance(FIRST_POINT, THIRD_POINT),
                    points.getDistance(SECOND_POINT, THIRD_POINT));
        }

        private static double getTriangleArea(double a, double b, double c) {
                double s = (a + b + c) / 2;
                return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
}

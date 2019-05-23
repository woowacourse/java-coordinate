package coordinate.model;

import coordinate.util.HeronFormula;

import java.util.List;

public class Triangle extends Shape {
        public Triangle(List<Point> points) {
                super(points);
                checkIsLine(points);
        }

        private void checkIsLine(List<Point> points) {
                if (points.get(FIRST_POINT).getIncline(points.get(SECOND_POINT))
                    == points.get(SECOND_POINT).getIncline(points.get(THIRD_POINT))) {
                        throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
                }
        }

        @Override
        public double getScore() {
                return HeronFormula.getTriangleArea(points.get(FIRST_POINT).getDistance(points.get(SECOND_POINT)),
                                                        points.get(FIRST_POINT).getDistance(points.get(THIRD_POINT)),
                                                        points.get(SECOND_POINT).getDistance(points.get(THIRD_POINT)));
        }
}

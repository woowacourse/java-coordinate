package coordinate.model;

import java.util.List;

public class Line extends Shape {
        public Line(List<Point> points) {
                super(points);
        }

        @Override
        public double getScore() {
                return points.get(FIRST_POINT).getDistance(points.get(SECOND_POINT));
        }
}

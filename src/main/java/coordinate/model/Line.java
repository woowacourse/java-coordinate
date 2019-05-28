package coordinate.model;

import coordinate.model.framework.Shape;

import java.util.List;

public class Line extends Shape {
        public Line(List<Point> points) {
                super(points);
        }

        @Override
        public double getScore() {
                return points.getDistance(FIRST_POINT,SECOND_POINT);
        }
}

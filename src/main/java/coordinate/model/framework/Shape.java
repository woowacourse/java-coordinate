package coordinate.model.framework;

import coordinate.model.Point;
import coordinate.model.Points;

import java.util.List;

public abstract class Shape implements IShape {
        protected Points points;

        protected Shape(List<Point> points) {
                this.points = new Points(points);
        }

        @Override
        public List<Point> getPoints() {
                return points.getPoints();
        }
}

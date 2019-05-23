package coordinate.model;

import java.util.Collections;
import java.util.List;

public abstract class Shape implements IShape {
        protected List<Point> points;

        protected Shape(List<Point> points) {
                Collections.sort(points);
                checkDuplication(points);
                this.points = points;
        }

        private void checkDuplication(List<Point> points) {
                for (int index = 0; index < points.size() - 1; index++) {
                        checkDuplicationOnePoint(points, index);
                }
        }

        private void checkDuplicationOnePoint(List<Point> points, int index) {
                if (points.get(index).equals(points.get(index + 1))) {
                        throw new IllegalArgumentException("좌표는 서로 중복이 되어서는 안됩니다.");
                }
        }

        public List<Point> getPoints() {
                return points;
        }
}

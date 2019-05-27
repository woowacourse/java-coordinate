package coordinate.model;

import java.util.Collections;
import java.util.List;

public class Points {
        private List<Point> points;

        public Points(List<Point> points) {
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

        public Double getDistance(int FromIndex, int ToIndex) {
                return Math.sqrt(Math.pow(points.get(FromIndex).getX() - points.get(ToIndex).getX(), 2)
                    + Math.pow(points.get(FromIndex).getY() - points.get(ToIndex).getY(), 2));
        }

        public double getIncline(int fromIndex, int toIndex) {
                if ((points.get(toIndex).getX()) == points.get(fromIndex).getX()) {
                        return Double.MAX_VALUE;
                }
                return (double) (points.get(toIndex).getY() - points.get(fromIndex).getY())
                    / (points.get(toIndex).getX() - points.get(fromIndex).getX());
        }
}

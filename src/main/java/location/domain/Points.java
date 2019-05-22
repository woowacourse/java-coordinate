package location.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Points {

    private final static String POINT_NULL_OR_BLANK_MSG = "포인트가 비어있습니다.";
    private final static String NOT_CREATE_SHAPE_MSG = "도형을 만들수 없습니다.";
    private static List<Point> points;

    public Points(List<Point> points) {
        isValid(points);
        compare(points);
        Points.points = points;
    }

    private void isValid(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(POINT_NULL_OR_BLANK_MSG);
        }
    }

    private void compare(List<Point> points) {
        Comparator<Point> pointComparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() == o2.getX()) {
                    return o1.getY() - o2.getY();
                }
                return o1.getX() - o2.getX();
            }
        };
        Collections.sort(points, pointComparator);
    }

    public Point get(int index) {
        return this.points.get(index);
    }

    public int size(){
        return this.points.size();
    }
}

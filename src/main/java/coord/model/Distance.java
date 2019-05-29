package coord.model;

import coord.view.ConsoleMessages;

public class Distance {

    public static final int POINT_COUNT = 2;

    public static double length(Points points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_COORDINATE.message());
        }
        Point A = points.get(0);
        Point B = points.get(1);
        return length(A, B);
    }

    public static double length(Point A, Point B) {
        return Math.sqrt(Math.pow((A.x - B.x), 2.0) + Math.pow((A.y - B.y), 2.0));
    }
}

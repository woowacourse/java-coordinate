package coord.model;

public class Distance {

    public static double length(Points points) {
        Point A = points.get(0);
        Point B = points.get(1);
        return length(A, B);
    }

    public static double length(Point A, Point B) {
        return Math.sqrt(Math.pow((A.x - B.x), 2.0) + Math.pow((A.y - B.y), 2.0));
    }
}

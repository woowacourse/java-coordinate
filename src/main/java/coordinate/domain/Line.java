package coordinate.domain;

public class Line {
    public static double length(Point pointA, Point pointB) {
        int xDistance = pointA.getDistanceX(pointB);
        int yDistance = pointA.getDistanceY(pointB);

        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
}

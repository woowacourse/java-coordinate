package coordinate.model;

import coordinate.model.Point;

public class Line {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getLength(){
        return point1.getDistance(point2);
    }
}

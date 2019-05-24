package coordinatecalculator;

import java.util.List;

public class Line extends Shape{
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    public Line(List<Point> points) {
        super(points);
    }

    public double getLength(){
        Point startPoint = super.getPoints().get(FIRST_POINT);
        Point endPoint = super.getPoints().get(SECOND_POINT);

        return startPoint.getDistance(endPoint);
    }

    @Override
    public double area() {
        return 0;
    }
}

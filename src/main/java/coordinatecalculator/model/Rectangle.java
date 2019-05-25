package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure {

    private static final int FIRST =0;
    private static final int SECOND =1;
    private static final int DIFFER_POINT_NUMBER = 2;
    private Points points;

    public Rectangle(Points points) {
        if (this.getDifferTwoPoints(points).size() != DIFFER_POINT_NUMBER) {
            throw new IllegalArgumentException("잘못된 직사각형 입니다.");
        }
        this.points = points;
    }

    private double calculateArea(List<Point> differTwoPoints) {
        Point firstPoint = differTwoPoints.get(FIRST);
        Point secondPoint = differTwoPoints.get(SECOND);
        return Math.abs(firstPoint.getXPoint().subtract(secondPoint.getXPoint().getValue())) *
                Math.abs(firstPoint.getYPoint().subtract(secondPoint.getYPoint().getValue()));
    }

    private List<Point> getDifferTwoPoints(Points points) {
        List<Point> differPoints = new ArrayList<>();
        Point firstPoint = points.getPoint(FIRST);
        differPoints.add(firstPoint);

        points.getPoints().stream()
                .filter(firstPoint::isDifferBothXY)
                .forEach(differPoints::add);
        return differPoints;
    }

    @Override
    public double area() {
        double area = calculateArea(getDifferTwoPoints(points));
        return Math.round(area * DECIMAL) / DECIMAL;
    }

    @Override
    public String toString() {
        return "사각형의 넓이는 " + area();
    }
}

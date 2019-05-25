package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure {

    private Points points;

    public Rectangle(Points points) {
        if(this.getDifferTwoPoints(points).size()!=2){
            throw new IllegalArgumentException("잘못된 직사각형 입니다.");
        }
        this.points = points;
    }

    private double calculateArea(List<Point> differTwoPoints) {
        Point firstPoint = differTwoPoints.get(0);
        Point secondPoint = differTwoPoints.get(1);
        return Math.abs(firstPoint.getXPoint().subtract(secondPoint.getXPoint().getValue())) *
                Math.abs(firstPoint.getYPoint().subtract(secondPoint.getYPoint().getValue()));
    }

    private List<Point> getDifferTwoPoints(Points points) {
        List<Point> differPoints = new ArrayList<>();
        Point firstPoint = points.getPoint(0);
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
    public String toString(){
        return "사각형의 넓이는 "+area();
    }
}

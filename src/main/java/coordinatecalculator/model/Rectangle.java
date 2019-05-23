package coordinatecalculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle {

    private double area;

    public Rectangle(List<Distance> distances) {
        this.area = calculateRectangleArea(distances);
//        if(diagonalPoint.getPoints().size() != 2){
//            throw new IllegalArgumentException("잘못된 직사각형 형식 입니다.");
//        }
    }

    private double calculateRectangleArea(List<Distance> distances){
        Set<Distance> distanceSet = new HashSet<>(distances);
        double result = 1;
        for(Distance distance : distanceSet){
            result *= distance.getDistance();
        }
        return result;
    }

    public double getArea() {
        return area;
    }

    //    public Points generateDiagonalPoint(Points points) {
//        diagonalPoint = Points.create();
//        diagonalPoint.addPoint(points.getPoint(0));
//        for (int i = 1; i < points.getPoints().size(); i++) {
//            checkRectangle(points, i);
//        }
//
//        return diagonalPoint;
//    }

//    private void checkRectangle(Points points, int index) {
//        if(diagonalPoint.getPoint(0).getyPoint().getValue() != points.getPoint(index).getyPoint().getValue()
//            && diagonalPoint.getPoint(0).getxPoint().getValue() != points.getPoint(index).getxPoint().getValue()){
//            diagonalPoint.addPoint(points.getPoint(index));
//        }
//    }
//
}

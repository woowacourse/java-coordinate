package coordinatecalculator.model;


import java.util.*;

public class Points {

    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;

    private List<Point> points;

    private Points() {
        this.points = new ArrayList<>();
    }

    public static Points create() {
        return new Points();
    }

    public void addPoint(Point point) {
        if(this.points.contains(point)){
            throw new IllegalArgumentException("두점이 중복되었습니다.");
        }
        this.points.add(point);
    }

    public Point getPoint(int index){
        return this.points.get(index);
    }

    public double distanceResult(){
        return Math.sqrt(this.getPoint(FIRST_POINT_INDEX).square(this.getPoint(SECOND_POINT_INDEX)));
    }

}

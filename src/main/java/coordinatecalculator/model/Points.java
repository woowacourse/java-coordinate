package coordinatecalculator.model;


import java.util.ArrayList;
import java.util.List;

public class Points {

    private List<Point> points;

    private Points() {
        this.points = new ArrayList<>();
    }

    public static Points create() {
        return new Points();
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public Point getPoint(int index){
        return this.points.get(index);
    }
}

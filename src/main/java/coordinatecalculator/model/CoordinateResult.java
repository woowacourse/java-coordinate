package coordinatecalculator.model;

import java.util.List;

public class CoordinateResult {

    List<Distance> distances;

    public CoordinateResult(Points points) {
        this.distances = points.generateDistances();
    }

    public double resultOfDistance() {
        return this.distances.get(distances.size() - 1).getDistance();
    }

    public double resultOfRectangleArea(){
        return new Rectangle(distances).getArea();
    }

    public double resultOfTriangleArea(){
        return new Triangle(distances).getArea();
    }

}

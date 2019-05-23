package coordinatecalculator.model;

import java.util.List;

public class Triangle extends Figure {

    private double area;

    public Triangle(List<Distance> distances) {
        this.area = calculateArea(distances);
    }

    @Override
    public double calculateArea(List<Distance> distances) {
        double firstLength = distances.get(0).getDistance();
        double secondLength = distances.get(1).getDistance();
        double thirdLength = distances.get(2).getDistance();

        final double pythagorean = firstLength * firstLength + secondLength * secondLength - thirdLength * thirdLength;
        return Math.sqrt(4 * firstLength * firstLength * secondLength * secondLength - pythagorean * pythagorean) / 4;
    }

    @Override
    public double getArea() {
        return Math.round(area * 1000) / 1000.0;
    }
}

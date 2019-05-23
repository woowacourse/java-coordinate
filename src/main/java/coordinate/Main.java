package coordinate;

import coordinate.model.PointsGenerator;
import coordinate.model.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle tri = new Triangle(PointsGenerator.makePoints("(1,1)-(1,1)-(1,1)"));
    }
}

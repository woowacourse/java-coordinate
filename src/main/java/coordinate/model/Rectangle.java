package coordinate.model;

import java.util.List;

public class Rectangle extends AbstractFigure {
    private Vector firstNearVector;
    private Vector secondNearVector;

    public Rectangle(List<Point> points) {
        super(points);
        checkRectangle(points);
    }

    private void checkRectangle(List<Point> points) {
        firstNearVector = new Vector(points.get(0), points.get(3));
        secondNearVector = new Vector(points.get(0), points.get(2));

        if (!(firstNearVector.getDotProduct(secondNearVector) == 0 &&
                points.get(1).equals(firstNearVector.sum(secondNearVector)))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int countOfPoints() {
        return 4;
    }

    @Override
    public double area() {
        return firstNearVector.getCrossProduct(secondNearVector);
    }
}

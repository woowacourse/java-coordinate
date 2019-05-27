package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Figure implements ResultPrintable {

    private final Points points;

    private Triangle(Points points) {
        this.points = points;
    }

    public static Triangle create(Points points) {
        return new Triangle(points);
    }

    @Override
    public double getArea() {
        List<Double> distances = new ArrayList<>();
        double s = 0;
        double result = 1;

        for (int i = 0; i < points.getSize(); i++) {
            int nextIndex = (i == points.getSize() - 1) ? 0 : i + 1;
            distances.add(points.pointsByIndex(i).getDistance(points.pointsByIndex(nextIndex)));
        }

        for (Double distance1 : distances) {
            s += distance1;
        }
        s = s / 2;

        for (Double distance : distances) {
            result *= s - distance;
        }

        result = Math.sqrt(s * result);

        return result;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public String getResultMessage() {
        return String.format("삼각형 넓이는 %.1f", getArea());
    }
}

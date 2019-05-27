package coordinatecalculator.model;

import java.util.List;

public class PointsFactory {

    public static Points generatePoints(String points) {
        List<String> values = StringSplitter.split(points);
        Points figurePoints = new Points(values);
        return figurePoints;
    }
}

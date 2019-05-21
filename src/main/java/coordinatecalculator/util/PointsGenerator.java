package coordinatecalculator.util;

import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.Points;

import java.util.ArrayList;
import java.util.List;

public class PointsGenerator {
    public static Points create(String input) {
        String[] inputs = input.split("-");
        List<Point> points = new ArrayList<>();
        //TODO: refactoring
        for (String s : inputs) {
            points.add(new Point(s.split("\\(|\\)|,")[1], s.split("\\(|\\)|,")[2]));
        }

        return new Points(points);
    }
}

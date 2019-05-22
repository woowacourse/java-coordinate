package coordinatecalculator.util;

import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.Points;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointsGenerator {
    public static Points create(String input) {
        String[] inputs = input.split("-");
        List<Point> points = new ArrayList<>();
        //TODO: refactoring
        for (String s : inputs) {
            points.add(new Point(s.split("\\(|\\)|,")[1], s.split("\\(|\\)|,")[2]));
        }

        checkDuplicatedPoint(points);

        return new Points(points);
    }

    private static void checkDuplicatedPoint(List<Point> points) {
        Set<Point> distinctPoints = new HashSet<>(points);
        if (distinctPoints.size() != points.size()) {
            throw new IllegalArgumentException("중복되는 점이 존재합니다. 다시 입력해주세요.");
        }
    }
}

package coordinatecalculator.util;

import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.Points;

import java.util.*;

public class PointsGenerator {
    private static final String DUPLICATED_POINT_MESSAGE = "중복되는 점이 존재합니다. 다시 입력해주세요.";

    public static Points create(String input) {
        String[] inputs = input.split("-");
        List<Point> points = new ArrayList<>();

        for (String s : inputs) {
            List<String> splittedPoint = Arrays.asList(s.split("\\(|\\)|,"));
            points.add(new Point(splittedPoint.get(1), splittedPoint.get(2)));
        }

        checkDuplicatedPoint(points);

        return new Points(points);
    }

    private static void checkDuplicatedPoint(List<Point> points) {
        Set<Point> distinctPoints = new HashSet<>(points);

        if (distinctPoints.size() != points.size()) {
            throw new IllegalArgumentException(DUPLICATED_POINT_MESSAGE);
        }
    }
}

package coordinate.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    Points points;

    public Triangle(Points points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (!isTriangle(points)) {
            throw new IllegalArgumentException("삼각형이 아닙니다");
        }
        this.points = points;
    }

    static boolean isTriangle(Points points) {
        List<Double> lineLengths = Arrays.asList(
                new Line(points.get(0), points.get(1)).calLength(),
                new Line(points.get(0), points.get(2)).calLength(),
                new Line(points.get(1), points.get(2)).calLength()
        );
        Collections.sort(lineLengths);
        if (lineLengths.get(0) + lineLengths.get(1) <= lineLengths.get(2)) {
            return false;
        }
        return true;
    }
}

package coordinatecalculator;

import java.util.Arrays;
import java.util.List;

interface Figure {
    String ERROR_POINTS_DUPLICATE
            = "위치가 같은 점(point)이 존재합니다. 각 점의 위치는 달라야 합니다.";

    static Figure of(Point... points) {
        return FigureFactory.of(Arrays.asList(points));
    } // Java 8 이상부터는 인터페이스에 static method 작성이 가능.

    double area();

    String getName();

    String toString();

    List<Point> getPoints();

    int getPointsCount();

    boolean equals(Object another);

    int hashCode();
}

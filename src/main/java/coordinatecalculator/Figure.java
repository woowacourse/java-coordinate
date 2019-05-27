package coordinatecalculator;

import java.util.Arrays;
import java.util.List;

interface Figure {
    String ERROR_POINTS_DUPLICATE
            = "입력된 점의 좌표가 중복됩니다.";

    static Figure of(Point... points) {
        return FigureFactory.of(Arrays.asList(points));
    } // Java 8 이상부터는 인터페이스에 static method 작성이 가능.

    double area();

    String getName();

    List<Point> getPoints();

    int getPointsCount();

    boolean equals(Object another);

    int hashCode();
}

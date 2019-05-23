package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

public class FigureRouter {
    private static final String INVALID_FIGURE_MESSAGE = "허용된 도형이 아닙니다. 다시 입력해주세요.";
    private static final int LINE_COUNT = 2;
    private static final int TRIANGLE_COUNT = 3;
    private static final int RECTANGLE_COUNT = 4;

    static Figure routing(Points points) {
        int countOfSize = points.size();

        if (countOfSize == LINE_COUNT) {
            return new Line(points);
        }
        if (countOfSize == TRIANGLE_COUNT) {
            return new Triangle(points);
        }
        if (countOfSize == RECTANGLE_COUNT) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException(INVALID_FIGURE_MESSAGE);
    }
}

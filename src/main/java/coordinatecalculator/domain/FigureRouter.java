package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

public class FigureRouter {
    private static final String INVALID_FIGURE_MESSAGE = "허용된 도형이 아닙니다. 다시 입력해주세요.";

    public static Figure routing(Points points) {
        int countOfPoints = points.size();

        try {
            return CountOfPoints.valueOf("_" + countOfPoints).getFigure(points);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_FIGURE_MESSAGE);
        }
    }
}

package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.HashMap;
import java.util.Map;

public class FigureRouter {
    private static final String INVALID_FIGURE_MESSAGE = "허용된 도형이 아닙니다. 다시 입력해주세요.";
    private static final Map<Integer, String> figuresTypes = new HashMap<>();
    static {
        figuresTypes.put(2, "LINE");
        figuresTypes.put(3, "TRIANGLE");
        figuresTypes.put(4, "RECTANGLE");
    }

    public static Figure routing(Points points) {
        int countOfPoints = points.size();

        try {
            return FigureType.valueOf(figuresTypes.get(countOfPoints)).getFigure(points);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_FIGURE_MESSAGE);
        }
    }
}

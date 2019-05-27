package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static final int POINT_CONDITION = 1;
    private static final int LINE_CONDITION = 2;
    private static final int TRIANGLE_CONDITION = 3;
    private static final int RECTANGLE_CONDITION = 4;
    private static final String EX_NO_FIGURE_CONDITION_MESSAGE = "만들 수 있는 도형이 없습니다. (가능한 도형은 점, 선, 삼각형, 사각형입니다.)";

    public Figure create(Coordinates coordinates) {
        if (coordinates.size() == POINT_CONDITION) {
            return new Point(coordinates);
        }
        if (coordinates.size() == LINE_CONDITION) {
            return new Line(coordinates);
        }
        if (coordinates.size() == TRIANGLE_CONDITION) {
            return new Triangle(coordinates);
        }
        if (coordinates.size() == RECTANGLE_CONDITION) {
            return new Rectangle(coordinates);
        }

        throw new IllegalArgumentException(EX_NO_FIGURE_CONDITION_MESSAGE);
    }
}

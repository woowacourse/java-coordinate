package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-28
 */
public enum FigureType {
    POINT(1),
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private static final String EX_NO_FIGURE_CONDITION_MESSAGE = "만들 수 있는 도형이 없습니다. (가능한 도형은 점, 선, 삼각형, 사각형입니다.)";
    private final int apex;

    FigureType(int apex) {
        this.apex = apex;
    }

    public static FigureType valueOf(int apex) {
        for (FigureType figureType : values()) {
            if (figureType.apex == apex) {
                return figureType;
            }
        }

        throw new IllegalArgumentException(EX_NO_FIGURE_CONDITION_MESSAGE);
    }
}

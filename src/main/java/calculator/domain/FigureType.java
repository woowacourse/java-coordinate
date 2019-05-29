package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-28
 */
public enum FigureType {
    LINE("직선", 2, new Points(), CalculateType.PERIMETER),
    TRIANGLE("삼각형", 3, new Points(), CalculateType.AREA),
    RECTANGLE("사각형", 4, new Points(), CalculateType.AREA);

    private static final String EX_NO_FIGURE_CONDITION_MESSAGE = "만들 수 있는 도형이 없습니다. (가능한 도형은 선, 삼각형, 사각형입니다.)";
    private final int apex;
    private final String type;
    private final CalculateType defaultCalculateType;
    private Points points;

    FigureType(String type, int apex, Points points, CalculateType defaultCalculateType) {
        this.type = type;
        this.apex = apex;
        this.points = points;
        this.defaultCalculateType = defaultCalculateType;
    }

    public static FigureType valueOf(Points points) {
        for (FigureType figureType : values()) {
            if (figureType.apex == points.size()) {
                figureType.points = points;
                return figureType;
            }
        }

        throw new IllegalArgumentException(EX_NO_FIGURE_CONDITION_MESSAGE);
    }

    public String getType() {
        return type;
    }

    public Points getPoints() {
        return points;
    }

    public CalculateType getDefaultCalculateType() {
        return defaultCalculateType;
    }
}

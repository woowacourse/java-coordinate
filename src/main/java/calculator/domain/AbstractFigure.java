package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public abstract class AbstractFigure implements Calculate {
    private final FigureType figureType;

    public AbstractFigure(FigureType figureType, FigureType defaultType) {
        this.figureType = figureType;
        checkFigureType(defaultType);
    }

    private void checkFigureType(FigureType defaultType) {
        if (!figureType.equals(defaultType)) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }
    }

    public void checkNotFigure(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return figureType.getType();
    }

    Points getPoints() {
        return figureType.getPoints();
    }

    public double calculateResult() {
        return calculateResult(figureType.getDefaultCalculateType());
    }

    public double calculateResult(CalculateType calculateType) {
        if (calculateType.equals(CalculateType.PERIMETER)) {
            return perimeter();
        }
        if (calculateType.equals(CalculateType.AREA)) {
            return area();
        }
        throw new IllegalArgumentException("잘못된 값입니다.");
    }

    public String getCalculateTarget() {
        return figureType.getDefaultCalculateType().getType();
    }

    abstract void checkFigureCondition();
}

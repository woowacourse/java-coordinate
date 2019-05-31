package coordinatecalculator.domain;

public class Line implements Figure {
    private static final String LINE_NAME = "선";
    private static final int EMPTY = 0;

    private PointGroup pointGroup;

    Line(final PointGroup pointGroup) {
        this.pointGroup = pointGroup;
    }

    public double getLength() {
        return pointGroup.getLength(FigureConstant.FIRST_POINT, FigureConstant.SECOND_POINT);
    }

    @Override
    public double area() {
        return EMPTY;
    }

    @Override
    public String getName() {
        return LINE_NAME;
    }
}

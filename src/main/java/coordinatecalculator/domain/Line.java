package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.AbstractFigure;

public class Line extends AbstractFigure {
    private static final String NAME = "선";
    private static final String RESULT_TYPE = "길이";

    private Line(final Points points) {
        super(points);
    }

    public static Line newInstance(final Points points) {
        return new Line(points);
    }

    @Override
    public double calculateResult() {
        return points.differenceBy(0, 1);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getResultType() {
        return RESULT_TYPE;
    }
}

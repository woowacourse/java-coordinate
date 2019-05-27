package coordinatecalculator.model;

public abstract class AbstractFigure implements Figure{

    protected final Points points;

    AbstractFigure(Points points){
        this.points = points;
    }

    @Override
    public double getResult() {
        return 0;
    }

    @Override
    public double calculateResult() {
        return 0;
    }
}

package coordinatecalculator.model;

public abstract class AbstractFigure implements Figure{
    protected final Points points;

    public AbstractFigure(Points points) {
        this.points = points;
    }

    //use not sure
    protected Point getPoint(int index) {
        return points.getPoint(index);
    }

    @Override
    public Points getPoints() {
        return points;
    }
}

package location.domain;

public class Line extends Figure {
    public Line(final Points points) {
        super(points);
        this.points = points;
    }


    @Override
    public double calculate() {
        return points.getTwoPointsDistance(0,1);
    }

    @Override
    public Points getPoints() {
        return this.points;
    }
}

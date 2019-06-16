package location.domain;

public class Line extends Figure {
    private Points points;
    public Line(final Points points) {
        checkSamePointValid(points.getPoints());
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

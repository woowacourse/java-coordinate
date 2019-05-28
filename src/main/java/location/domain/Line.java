package location.domain;

public class Line extends Figure {
    private static final int SQUARE = 2;

    public Line(final Points points) {
        super(points);
        this.points = points;
    }

    public double calculateLinelength(Point points){
        return Math.sqrt(Math.pow((points.get(0).getXCoordinate() - points.get(1).getXCoordinate()), SQUARE)
                + Math.pow((points.get(0).getyCoordinate() - points.get(1).getyCoordinate()), SQUARE));
    }

    @Override
    public double calculate() {
        return Math.sqrt(Math.pow((points.get(0).getXCoordinate() - points.get(1).getXCoordinate()), SQUARE)
                + Math.pow((points.get(0).getyCoordinate() - points.get(1).getyCoordinate()), SQUARE));
    }

    @Override
    public Points getPoints() {
        return this.points;
    }
}

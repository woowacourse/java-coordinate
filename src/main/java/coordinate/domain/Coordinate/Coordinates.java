package coordinate.domain.Coordinate;

public class Coordinates {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    private Coordinates(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Coordinates create(int xCoordinate, int yCoordinate) {
        return new Coordinates(new XCoordinate(xCoordinate), new YCoordinate(yCoordinate));
    }

    public double getDistanceWith(Coordinates coor2) {
        return Math.sqrt(Math.pow(this.xCoordinate.getValue() - coor2.xCoordinate.getValue(), 2)
                + Math.pow(this.yCoordinate.getValue()- coor2.yCoordinate.getValue(),2));
    }
}

package coordinate;

public class Coordinate {
    private final int xCoordinate;
    private final int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getDistanceWith(Coordinate coor2) {
        return Math.sqrt(Math.pow(this.xCoordinate - coor2.xCoordinate, 2)
                + Math.pow(this.yCoordinate- coor2.yCoordinate,2));

    }
}

package coordinatecalculator.model.coordinate;

public class CoordinateCalculator {
    private static final int SQUARE = 2;

    public static double lineLength(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(dx(a, b), SQUARE) + Math.pow(dy(a, b), SQUARE));
    }

    public static double gradient(Coordinate a, Coordinate b) {
        return (double) dy(a, b) / dx(a, b);
    }

    private static int dx(Coordinate a, Coordinate b) {
        return a.getX() - b.getX();
    }

    private static int dy(Coordinate a, Coordinate b) {
        return a.getY() - b.getY();
    }
}

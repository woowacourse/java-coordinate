package coordinatecalculator.model;

public class Line implements Comparable<Line> {
    private final Coordinate coordinateA;
    private final Coordinate coordinateB;
    private final double length;

    public Line(Coordinate coordinateA, Coordinate coordinateB) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
        this.length = calculateLength();
    }

    private double calculateLength() {
        int dx = Math.abs(coordinateA.getX() - coordinateB.getX());
        int dy = Math.abs(coordinateA.getY() - coordinateB.getY());
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double getLength() {
        return this.length;
    }

    public double getGradient() {
        try {
            return (double)(coordinateA.getY() - coordinateB.getY())
                    / (coordinateA.getX() - coordinateB.getX());
        } catch (ArithmeticException e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(this.length, o.getLength());
    }
}

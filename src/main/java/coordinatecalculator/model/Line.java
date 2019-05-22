package coordinatecalculator.model;

public class Line {
    private final Coordinate coordinateA;
    private final Coordinate coordinateB;
    private final double length;

    public Line(Coordinate coordinateA, Coordinate coordinateB) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
        this.length = calculateLength();
    }

    private double calculateLength() {
        int dx = Math.abs(coordinateA.getXValue() - coordinateB.getXValue());
        int dy = Math.abs(coordinateA.getYValue() - coordinateB.getYValue());
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double getLength(){
        return this.length;
    }
}

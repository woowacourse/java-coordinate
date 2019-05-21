package coordinatecalculator.domain;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calculate(int x, int y) {
        return Math.sqrt(Math.pow(Math.abs(x - this.x), 2) + Math.pow(Math.abs(y - this.y), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

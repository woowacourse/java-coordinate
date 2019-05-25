package location.domain;

public abstract class Figure implements Calculator {
    private static final double MAX = Double.MAX_VALUE;
    private static final int SQUARE = 2;
    final Points points;

    public Figure(Points points) {
        this.points = points;
    }

    double calculateTilt(final Point point, final Point point1) {
        double denominator = (double) (point.getX() - point1.getX());
        double molecule = (double) (point.getY() - point1.getY());
        if (denominator == 0) {
            denominator = MAX;
        }
        return molecule / denominator;
    }

    double calculateLine(final Point point1, final Point point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), SQUARE)
                + Math.pow((point1.getY() - point2.getY()), SQUARE));
    }

    public abstract Points getPoints();
}

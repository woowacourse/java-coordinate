package location.domain;

public class Triangle extends Shape {
    private static final String SAME_LINE_MSG = "세점 이상이 한 선상에 있습니다.";
    private static final int SQUARE = 2;
    private final Points points;

    public Triangle(Points points) {
        super(points);
        checkValid(points);
        this.points = points;
    }

    private void checkValid(Points points) {
        checkSameLine(points);
    }

    private void checkSameLine(Points points) {
        if (isSameLine(points)) {
            throw new IllegalArgumentException(SAME_LINE_MSG);
        }
    }

    private boolean isSameLine(Points points) {
        return calculateTilt(points.get(0), points.get(1)) == calculateTilt(points.get(1), points.get(2));
    }

    private double calculateTilt(final Point point, final Point point1) {
        return (double)(point.getY()-point1.getY())/(double)(point.getX()-point1.getX());
    }


    private double calculateLine(final Point point1, final Point point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }


    @Override
    public Double calculate() {
        double frontTerm = 4 * Math.pow(calculateLine(points.get(0), points.get(1)), SQUARE) * Math.pow(calculateLine(points.get(1), points.get(2)), SQUARE);
        double rearTerm = (Math.pow(calculateLine(points.get(0), points.get(1)), SQUARE) + Math.pow(calculateLine(points.get(1), points.get(2)), SQUARE) - Math.pow(calculateLine(points.get(2), points.get(0)), 2));
        return Math.sqrt(frontTerm - Math.pow(rearTerm, SQUARE)) / 4;
    }
}



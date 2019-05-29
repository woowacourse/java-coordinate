package location.domain;

public class Triangle extends Figure {
    private final String SAME_LINE_MSG = "세점 이상이 한 선상에 있습니다.";
    private final int SQUARE = 2;

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
        return points.getTwoPointsTilt(0, 1) == points.getTwoPointsTilt(1, 2);
    }

    @Override
    public double calculate() {
        double frontTerm = 4 * Math.pow(points.getTwoPointsDistance(0, 1), SQUARE)
                * Math.pow(points.getTwoPointsDistance(1, 2), SQUARE);
        double rearTerm = (Math.pow(points.getTwoPointsDistance(0, 1), SQUARE)
                + Math.pow(points.getTwoPointsDistance(1, 2), SQUARE)
                - Math.pow(points.getTwoPointsDistance(2, 0), 2));
        return Math.sqrt(frontTerm - Math.pow(rearTerm, SQUARE)) / 4;
    }

    @Override
    public Points getPoints() {
        return this.points;
    }

}



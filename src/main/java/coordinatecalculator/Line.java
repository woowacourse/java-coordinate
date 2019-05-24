package coordinatecalculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Line {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final String DUPLICATED_POINTS = "입력한 좌표가 중복됩니다.";

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        checkValidLine();
    }

    private void checkValidLine() {
        if(isDuplicatePoints()){
            throw new IllegalArgumentException(DUPLICATED_POINTS);
        }
    }

    private boolean isDuplicatePoints() {
        Set<Point> uniquePoints = new HashSet<>(points);
        return uniquePoints.size() != points.size();
    }

    public double getLength() {
        Point startPoint = points.get(FIRST_POINT);
        Point endPoint = points.get(SECOND_POINT);

        return startPoint.getDistance(endPoint);
    }
}

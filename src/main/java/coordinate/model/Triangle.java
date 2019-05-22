package coordinate.model;

import java.util.Collections;
import java.util.List;

public class Triangle {
    List<Point> points;
    public Triangle(List<Point> points) {
        checkDupliation(points);
        checkIsLine(points);
        this.points = points;
    }

    private void checkIsLine(List<Point> points) {
        Collections.sort(points);
        if(points.get(0).getIncline(points.get(1))
                == points.get(1).getIncline(points.get(2))){
            throw new IllegalArgumentException("세점이 한점이 있으면 안됩니다.");
        }
    }

    private void checkDupliation(List<Point> points) {
        Collections.sort(points);
        for (int i = 0; i < points.size()-1; i++) {
            checkDuplicationOnePoint(points, i);
        }
    }

    private void checkDuplicationOnePoint(List<Point> points, int i) {
        if(points.get(i).equals(points.get(i+1))){
            throw new IllegalArgumentException("중복 좌표 오류");
        }
    }

    public boolean getArea() {

    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Square {

    private final List<Point> points;

    public Square(final List<Point> points) {
        this.points = new ArrayList<>(points);
        validate();
    }

    private void validate() {
        validateSize();
        validateDuplication();
        validateRectangle();
    }

    private void validateRectangle() {
        // todo: 개선점 생각하기
        int cnt = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;
                if (points.get(i).isMatchX(points.get(j))){
                    cnt++;
                }
                if (points.get(i).isMatchY(points.get(j))) {
                    cnt++;
                }
            }
        }
        if (cnt != 8) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private void validateSize() {
        if (this.points.size() != 4) {
            throw new IllegalArgumentException("점이 4개가 아닙니다.");
        }
    }

    private void validateDuplication() {
        if (new HashSet<>(this.points).size() != 4) {
            throw new IllegalArgumentException("중복된 점이 있습니다.");
        }
    }
}

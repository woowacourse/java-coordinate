package coordinate.domain;

import java.util.Arrays;

public class Square {
    private final Points points;
    private Line height;
    private Line width;

    public Square(final Points points) {
        this.points = points;
        validate();
    }

    private void validate() {
        validateSize();
        validateRectangle();
    }

    private void validateRectangle() {
        // todo: 개선점 생각하기
        int cnt = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;
                if (points.get(i).isMatchX(points.get(j))) {
                    cnt++;
                    height = new Line(Points.of(Arrays.asList(points.get(i), points.get(j))));
                }
                if (points.get(i).isMatchY(points.get(j))) {
                    cnt++;
                    width = new Line(Points.of(Arrays.asList(points.get(i), points.get(j))));
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

    public double area() {
        return height.length() * width.length();
    }
}

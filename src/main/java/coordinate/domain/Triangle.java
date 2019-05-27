package coordinate.domain;

public class Triangle implements Figure {
    static final int POINT_NUMBER = 3;
    private Lines lines;

    Triangle(Lines lines) {
        if (isNotTriangle(lines)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
        this.lines = lines;
    }

    private boolean isNotTriangle(Lines lines) {
        return lines.isNotTriangle();
    }
    @Override
    public double getArea() {
        return lines.calculateTriangleArea();
    }

    @Override
    public String getResult() {
        return "삼각형의 넓이는 %.2f 입니다.";
    }
}

package coordinate.domain;

import java.util.List;

public class Triangle implements Figure {
    private List<Line> lines;

    Triangle(List<Line> lines) {
        if (!checkTriangle(lines)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
        this.lines = lines;
    }

    private boolean checkTriangle(List<Line> temporaryLines) {
        return temporaryLines.get(1).isTriangle(temporaryLines.get(2), temporaryLines.get(0));
    }
    @Override
    public double findArea() {
        return lines.get(0).findTriangleArea(lines.get(1), lines.get(1));
    }

    @Override
    public String findResult() {
        return "삼각형의 넓이는 %.2f 입니다.";
    }
}

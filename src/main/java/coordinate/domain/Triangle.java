package coordinate.domain;

import java.util.List;

public class Triangle {
    private List<Line> lines;

    public Triangle(CoordinateList coordinateList) {
        List<Line> temporaryLines = coordinateList.findLine();
        if (!checkTriangle(temporaryLines)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
        lines = temporaryLines;
    }

    private boolean checkTriangle(List<Line> temporaryLines) {
        return temporaryLines.get(1).isTriangle(temporaryLines.get(2), temporaryLines.get(0));
    }

    public double findArea() {
        return lines.get(0).findTriangleArea(lines.get(1), lines.get(1));
    }
}

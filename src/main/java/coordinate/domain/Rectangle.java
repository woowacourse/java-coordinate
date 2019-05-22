package coordinate.domain;

import java.util.Collections;
import java.util.List;

public class Rectangle {
    private static final int LINE_COUNT = 4;
    List<Line> lines;

    public Rectangle(List<Line> lines) {
        validateLines(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validateLines(List<Line> lines) {
        validateLineCount(lines);
        validateLinesLength(lines);
        validateLinesConnection(lines);
        validateOrthogonal(lines);
    }

    private void validateLineCount(List<Line> lines) {
        if (lines.size() != LINE_COUNT) {
            throw new IllegalArgumentException("사각형은 4개의 선으로 이루어집니다.");
        }
    }

    private void validateLinesConnection(List<Line> lines) {

    }

    private void validateOrthogonal(List<Line> lines) {
        if(!lines.get(0).orthogonalTo(lines.get(1))){
            throw new IllegalStateException("직사각형이 아닙니다");
        }
    }

    private void validateLinesLength(List<Line> lines) {
        if (lines.get(0).length() != lines.get(2).length()
            || lines.get(1).length() != lines.get(3).length()){
            throw new IllegalStateException("직사각형이 아닙니다");
        }
    }

    public double area() {
        return lines.get(0).length() * lines.get(1).length();
    }
}

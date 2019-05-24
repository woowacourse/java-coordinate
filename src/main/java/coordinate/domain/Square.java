package coordinate.domain;

import java.util.List;

public class Square implements Figure {
    private List<Line> lines;

    Square(List<Line> lines) {
        isRectangle(lines);
        this.lines = lines;
    }

    private void isRectangle(List<Line> lines) {
        for (int i = 0; i < lines.size(); i += 2) {
            checkSameLength(lines, i);
        }
    }

    private void checkSameLength(List<Line> lines, int index) {
        if (!(lines.get(index).equals(lines.get(index + 1)))) {
            throw new IllegalArgumentException("직사각형이나 정사각형이 아닙니다.");
        }
    }

    @Override
    public double findArea() {
        return lines.get(3).findSquareArea(lines.get(5));
    }

    @Override
    public String findResult() {
        return "사각형의 넓이는 %.2f 입니다.";
    }
}

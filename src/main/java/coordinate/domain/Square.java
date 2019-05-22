package coordinate.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Square implements Figure {
    private List<Line> lines;

    Square(CoordinateList coordinateList) {
        List<Line> temporaryLines = coordinateList.findLine();
        isRhombus(temporaryLines);
        isTrapezoid(temporaryLines);
        this.lines = temporaryLines;
    }

    //사다리꼴
    private void isTrapezoid(List<Line> lines) {
        List<Line> temporaryLine = lines.stream().distinct().collect(Collectors.toList());
        if (temporaryLine.size() > 3 || temporaryLine.get(0).isInOneLine(temporaryLine.get(temporaryLine.size() - 1))) {
            throw new IllegalArgumentException("사다리꼴이거나 일직선은 안됩니다.");
        }
    }

    //마름모
    private void isRhombus(List<Line> lines) {
        Line diagonal = lines.get(0);
        if (Collections.indexOfSubList(lines, Arrays.asList(diagonal)) == -1) {
            throw new IllegalArgumentException("마름모는 안됩니다.");
        }
    }

    @Override
    public double findArea() {
        return lines.get(3).findSquareArea(lines.get(5));
    }
}

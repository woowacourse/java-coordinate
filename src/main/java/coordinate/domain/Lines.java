package coordinate.domain;

import java.util.HashSet;
import java.util.List;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateNotNull(lines);
        validateNoDuplication(lines);
        this.lines = lines;
    }

    private void validateNoDuplication(List<Line> lines) {
        if ((new HashSet<>(lines)).size() != lines.size()) {
            throw new IllegalArgumentException("중복되는 라인이 존재할 수 없습니다.");
        }
    }

    public boolean isOrthogonal(int i, int j) {
        Vector v1 = getVector(i);
        Vector v2 = getVector(j);

        return v1.innerProduct(v2) == 0;
    }

    public boolean isParallel(int i, int j) {
        Vector v1 = getVector(i);
        Vector v2 = getVector(j);

        return v1.innerProduct(v2) == 1;
    }

    public double sumLength() {
        return lines.stream().mapToDouble(line -> line.length()).sum();
    }

    public Vector getVector(int i) {
        return new Vector(getLine(i));
    }

    private Line getLine(int index) {
        validateIndex(index);
        return lines.get(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException("적합하지 않은 인덱스입니다.");
        }
    }

    public int getSize() {
        return lines.size();
    }
}

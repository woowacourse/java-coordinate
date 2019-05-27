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

    public Line getLine(int index) {
        validateIndex(index);
        return lines.get(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= lines.size()) {
            throw new NullPointerException("적합하지 않은 인덱스입니다.");
        }
    }

    public int getSize() {
        return lines.size();
    }
}

package coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BoardSingleLine {
    private final List<Boolean> line;

    public BoardSingleLine() {
        List<Boolean> initLine = new ArrayList<>(Collections.nCopies(Board.MAX_BOARD_SIZE, Boolean.FALSE));
        this.line = initLine;
    }

    public void pointing(int pointIndex) {
        line.set(pointIndex, true);
    }

    public List<Boolean> getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardSingleLine that = (BoardSingleLine) o;
        return Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}

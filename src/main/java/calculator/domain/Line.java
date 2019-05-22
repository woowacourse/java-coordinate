package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line {

    private List<Boolean> line;

    public Line() {
        this.line = new ArrayList<>(Collections.nCopies(24, false));
    }

    public boolean get(int index) {
        return line.get(index);
    }

    public int size() {
        return line.size();
    }

    public void drawX(int xCoordinate) {
        line.set(xCoordinate, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

}

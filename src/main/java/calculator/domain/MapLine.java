package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class MapLine implements Iterable<Boolean> {

    private List<Boolean> line;

    public MapLine() {
        this.line = new ArrayList<>(Collections.nCopies(25, false));
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
        MapLine line1 = (MapLine) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return line.iterator();
    }
}

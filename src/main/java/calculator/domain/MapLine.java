package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class MapLine implements Iterable<Boolean> {

    private static final int MAX_SIZE = 25;
    private List<Boolean> mapLine;

    public MapLine() {
        this.mapLine = new ArrayList<>(Collections.nCopies(MAX_SIZE, false));
    }

    public boolean get(int index) {
        return mapLine.get(index);
    }

    public int size() {
        return mapLine.size();
    }

    public void drawX(int xCoordinate) {
        mapLine.set(xCoordinate, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapLine line1 = (MapLine) o;
        return Objects.equals(mapLine, line1.mapLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapLine);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return mapLine.iterator();
    }
}

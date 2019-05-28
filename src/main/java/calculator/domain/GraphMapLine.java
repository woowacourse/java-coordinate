package calculator.domain;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class GraphMapLine implements Iterable<Boolean> {

    private static final int MAX_SIZE = (int) IntStream.rangeClosed(0, 24).count();
    private List<Boolean> graphMapLine;

    public GraphMapLine() {
        this.graphMapLine = new ArrayList<>(Collections.nCopies(MAX_SIZE, false));
    }

    public boolean get(int index) {
        return graphMapLine.get(index);
    }

    public int size() {
        return graphMapLine.size();
    }

    public void plotX(int xCoordinate) {
        graphMapLine.set(xCoordinate, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphMapLine line1 = (GraphMapLine) o;
        return Objects.equals(graphMapLine, line1.graphMapLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphMapLine);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return graphMapLine.iterator();
    }
}

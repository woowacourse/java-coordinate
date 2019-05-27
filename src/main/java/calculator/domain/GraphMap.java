package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class GraphMap implements Iterable<GraphMapLine> {

    private static final int MAX_SIZE = 25;
    private List<GraphMapLine> graphMap;

    public GraphMap() {
        this.graphMap = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            graphMap.add(new GraphMapLine());
        }
    }

    public void drawCoordinate(Coordinate coordinate) {
        graphMap.get(coordinate.getY()).drawX(coordinate.getX());
    }

    public boolean isCoordinateDrawn(Coordinate coordinate) {
        return graphMap.get(coordinate.getY()).get(coordinate.getX());
    }

    public int size() {
        return graphMap.size();
    }

    public GraphMapLine getMapLine(int index) {
        return graphMap.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphMap graphMap1 = (GraphMap) o;
        return Objects.equals(graphMap, graphMap1.graphMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphMap);
    }

    @Override
    public Iterator<GraphMapLine> iterator() {
        return graphMap.iterator();
    }

}

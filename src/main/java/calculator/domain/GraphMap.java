package calculator.domain;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class GraphMap implements Iterable<GraphMapLine> {

    private static final int MAX_SIZE = (int) IntStream.rangeClosed(0, 24).count();
    private List<GraphMapLine> graphMap;

    public GraphMap() {
        this.graphMap = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            graphMap.add(new GraphMapLine());
        }
    }

    public GraphMap(List<GraphMapLine> graphMap) {
        this.graphMap = graphMap;
    }

    public void plotCoordinate(Coordinate coordinate) {
        graphMap.get(coordinate.getY()).plotX(coordinate.getX());
    }

    public GraphMap plotCoordinate(Figure figure) {
        for (Coordinate coordinate : figure.getCoordinates()) {
            plotCoordinate(coordinate);
        }
        return new GraphMap(graphMap);
    }

    public boolean isPlottedCoordinate(Coordinate coordinate) {
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

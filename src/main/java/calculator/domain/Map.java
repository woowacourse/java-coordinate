package calculator.domain;

import java.util.*;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class Map implements Iterable<MapLine> {

    private static final int MAX_SIZE = 25;
    private List<MapLine> map;

    public Map(Coordinates coordinates) {
        this.map = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            map.add(new MapLine());
        }

        for (Coordinate coordinate : coordinates) {
            drawCoordinate(coordinate);
        }
    }

    public void drawCoordinate(Coordinate coordinate) {
        map.get(coordinate.getYCoordinate()).drawXCoordinate(coordinate.getXCoordinate());
    }

    public boolean isCoordinateDrawn(Coordinate coordinate) {
        return map.get(coordinate.getYCoordinate()).get(coordinate.getXCoordinate());
    }

    public int size() {
        return map.size();
    }

    public MapLine getMapLine(int index) {
        return map.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map1 = (Map) o;
        return Objects.equals(map, map1.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    @Override
    public Iterator<MapLine> iterator() {
        return map.iterator();
    }

}

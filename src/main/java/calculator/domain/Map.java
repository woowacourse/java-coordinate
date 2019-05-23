package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Map implements Iterable<Line> {

    List<Line> map;

    public Map() {
        this.map = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            map.add(new Line());
        }
    }

    public void drawPoint(Point point) {
        map.get(point.getY()).drawX(point.getX());
    }

    public boolean isPointDrawn(Point point) {
        return map.get(point.getY()).get(point.getX());
    }

    public int size() {
        return map.size();
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
    public Iterator<Line> iterator() {
        return map.iterator();
    }

    public Line getLine(int index) {
        return map.get(index);
    }
}

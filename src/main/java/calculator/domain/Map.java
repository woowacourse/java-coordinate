package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Map {

    List<Line> map;

    public Map() {
        this.map = new ArrayList<>(Collections.nCopies(24,new Line()));
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


}

package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class LinesGenerator {
    public static Lines generator(Points points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.getSize(); i++) {
            lines.add(new Line(points.getIndex(i), points.getIndex((i + 1) % points.getSize())));
        }
        return new Lines(lines);
    }
}

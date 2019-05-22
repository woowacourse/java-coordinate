package coordinate.domain.generator;

import coordinate.domain.Line;
import coordinate.domain.Lines;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinesTriangleGenerator implements LinesGenerator {
    private final Points points;

    public LinesTriangleGenerator(final Points points) {
        this.points = points;
    }

    @Override
    public Lines generate() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                lines.add(new Line(Points.of(Arrays.asList(points.get(i), points.get(j)))));
            }
        }

        return new Lines(lines);
    }
}

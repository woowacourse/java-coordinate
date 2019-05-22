package coordinate.domain.generator;

import coordinate.domain.Line;
import coordinate.domain.Lines;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinesSquareGenerator implements LinesGenerator {
    private final Points points;

    public LinesSquareGenerator(final Points points) {
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
        lines = filterDiagonal(lines);
        return new Lines(lines);
    }

    private List<Line> filterDiagonal(List<Line> lines) {
        lines = lines.stream()
                .sorted((line1, line2) -> (int) (line1.length() - line2.length()))
                .limit(lines.size() - 2)
                .collect(Collectors.toList());
        return lines;
    }
}

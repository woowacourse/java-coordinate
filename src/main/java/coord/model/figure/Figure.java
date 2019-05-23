package coord.model.figure;

import coord.model.Combinations;
import coord.model.Line;
import coord.model.Point;
import coord.model.Points;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
    protected final Points points;
    protected double areaCache = .0;

    public static ConvexPolygon getConvexPolygon(Points points) {
        final Points actualPoints = removeRedundantPoints(points);
        if (actualPoints.number() < 3) {
            throw new IllegalArgumentException("점의 개수가 너무 적습니다.");
        }
        if (actualPoints.number() == 3) {
            return new Triangle(actualPoints);
        }
        final List<Line> outlines = getOutlines(actualPoints);
        if (outlines.size() != points.number()) {
            throw new IllegalArgumentException("오목한 도형은 현재 지원하지 않습니다.");
        }
        return new ConvexPolygon(new Points(deconstructOutlines(alignConnectedLines(outlines))));
    }

    private static Points removeRedundantPoints(List<Point> points, int count) {
        if (count == 0) {
            return new Points(points);
        }
        Combinations comb = new Combinations(points.size() - 1, 2);
        while(comb.hasNext()) {
            List<Integer> pair = comb.next();
            if (new Line(points.get(pair.get(0) + 1), points.get(pair.get(1) + 1)).includes(points.get(0))) {
                points.remove(0);
                return removeRedundantPoints(points, --count);
            }
        }
        points.add(points.remove(0));
        return removeRedundantPoints(points, --count);
    }

    private static Points removeRedundantPoints(Points points) {
        return removeRedundantPoints(new ArrayList<>(points.getPoints()), points.number());
    }

    private static List<Line> getOutlines(Points points) {
        return getOutlines(getEveryLines(points));
    }

    private static List<Line> getOutlines(List<Line> lines) {
        List<Line> exclude = new ArrayList<>();
        Combinations comb = new Combinations(lines.size(), 2);
        while (comb.hasNext()) {
            List<Integer> pair = comb.next();
            Line a = lines.get(pair.get(0));
            Line b = lines.get(pair.get(1));
            if (a.intersectsWith(b)) {
                exclude.add(a);
                exclude.add(b);
            }
        }
        lines.removeAll(exclude);
        return lines;
    }

    private static List<Line> alignConnectedLines(List<Line> lines) {
        return alignConnectedLines(lines, 0);
    }

    private static List<Line> alignConnectedLines(List<Line> lines, int index) {
        if (index == lines.size() - 1) {
            return lines;
        }
        int target = index + 1;
        while (!lines.get(index).isConnectedTo(lines.get(target))) {
            target++;
        }
        lines.add(index + 1, lines.remove(target));
        return alignConnectedLines(lines, index + 1);
    }

    private static List<Line> getEveryLines(Points points) {
        final List<Line> everyLines = new ArrayList<>();
        Combinations comb = new Combinations(points.number(), 2);
        while (comb.hasNext()) {
            List<Integer> pair = comb.next();
            everyLines.add(new Line(points.get(pair.get(0)), points.get(pair.get(1))));
        }
        return everyLines;
    }

    private static List<Point> deconstructOutlines(List<Line> outlines) {
        List<Point> result = new ArrayList<>();
        if (outlines.get(1).includes(outlines.get(0).P)) {
            result.add(outlines.get(0).Q);
        }
        return deconstructOutlines(outlines, result, 0);
    }

    private static List<Point> deconstructOutlines(List<Line> outlines, List<Point> result, int index) {
        if (result.size() == outlines.size()) {
            return result;
        }
        if (!result.contains(outlines.get(index).P)) {
            result.add(outlines.get(index).P);
        }
        if (!result.contains(outlines.get(index).Q)) {
            result.add(outlines.get(index).Q);
        }
        return deconstructOutlines(outlines, result, index + 1);
    }

    public static ConvexPolygon getConvexPolygon(Point... points) {
        return getConvexPolygon(new Points(points));
    }

    protected Figure(Points points) {
        this.points = points;
    }

    public abstract double area();

    public int getNumberOfAngles() {
        return points.number();
    }
}

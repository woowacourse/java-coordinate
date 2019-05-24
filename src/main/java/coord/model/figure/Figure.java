package coord.model.figure;

import coord.model.utils.Combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Figure {
    protected final Points points;
    protected double areaCache = .0;

    public static ConvexPolygon makeConvexPolygonFrom(Points points) {
        final Points actualPoints = removeRedundantPoints(points);
        if (actualPoints.number() < 3) {
            throw new IllegalArgumentException("점의 개수가 너무 적습니다. 3점 이상이 일직선상에 존재합니다.");
        }
        return makeConvexPolygonFromValidated(actualPoints);
    }

    private static ConvexPolygon makeConvexPolygonFromValidated(Points points) {
        if (points.number() == 3) {
            return new Triangle(points);
        }
        final List<Line> outlines = getOutlinesOfConvexPolygon(points);
        if (outlines.size() != points.number()) {
            throw new IllegalArgumentException("볼록도형이 아닙니다.");
        }
        return new ConvexPolygon(new Points(deconstructOutlines(alignConnectedLines(outlines))));
    }

    private static Points removeRedundantPoints(Points points) {
        List<Point> src = new ArrayList<>();
        src.addAll(points.getPoints());
        return removeRedundantPoints(src, new ArrayList<>());
    }

    private static Points removeRedundantPoints(List<Point> points, List<Point> result) {
        points.add(points.remove(0));
        if (result.contains(points.get(0))) {
            return new Points(result);
        }
        Combinations comb = new Combinations(points.size() - 1, 2);
        while (comb.hasNext()) {
            List<Integer> pair = comb.next();
            if (new Line(points.get(pair.get(0) + 1), points.get(pair.get(1) + 1)).includes(points.get(0))) {
                return removeRedundantPoints(points, result);
            }
        }
        result.add(points.get(0));
        return removeRedundantPoints(points, result);
    }

    private static List<Line> getOutlinesOfConvexPolygon(Points points) {
        List<Line> result = getEveryLines(points);
        List<Line> exclude = getIntersectingLines(result);
        result.removeAll(exclude);
        return result;
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

    private static List<Line> getIntersectingLines(List<Line> lines) {
        Set<Line> result = new HashSet<>();
        Combinations comb = new Combinations(lines.size(), 2);
        while (comb.hasNext()) {
            List<Integer> pair = comb.next();
            if (lines.get(pair.get(0)).intersectsWith(lines.get(pair.get(1)))) {
                result.add(lines.get(pair.get(0)));
                result.add(lines.get(pair.get(1)));
            }
        }
        return new ArrayList<>(result);
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

    public static ConvexPolygon makeConvexPolygonFrom(Point... points) {
        return makeConvexPolygonFrom(new Points(points));
    }

    protected Figure(Points points) {
        this.points = points;
    }

    public abstract double area();

    public int getNumberOfAngles() {
        return points.number();
    }
}
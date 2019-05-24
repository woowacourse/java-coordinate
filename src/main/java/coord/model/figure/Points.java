package coord.model.figure;

import java.util.*;

public final class Points {
    private final List<Point> points;

    public Points(Set<Point> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
    }

    public Points(List<Point> points) {
        this(new LinkedHashSet<>(points));
    }

    public Points(Point ... points) {
        this(new LinkedHashSet<>(Arrays.asList(points)));
    }

    public int number() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        String result = points.toString();
        return result.substring(1, result.length() - 1);
    }
}
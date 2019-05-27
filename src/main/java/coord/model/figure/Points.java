package coord.model.figure;

import java.util.*;

public final class Points implements Iterable<Point> {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(new LinkedHashSet<>(points)));
    }

    public Points(Point ... points) {
        this(Arrays.asList(points));
    }

    public Points(Points points, Comparator<Point> criteria) {
        List<Point> aligned = new ArrayList<>();
        aligned.addAll(points.points);
        aligned.sort(criteria);
        this.points = Collections.unmodifiableList(aligned);
    }

    public int number() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }

    @Override
    public String toString() {
        String result = points.toString();
        return result.substring(1, result.length() - 1);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Points)) {
            return false;
        }
        Points rhs = (Points) o;
        return Objects.equals(new HashSet<>(points), new HashSet<>(rhs.points));
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
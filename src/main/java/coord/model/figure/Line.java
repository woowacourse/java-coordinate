package coord.model.figure;

import java.util.Objects;

public final class Line {
    private final Point p;
    private final Point q;

    public Line(Point p, Point q) {
        Points points = new Points(new Points(p, q), (a, b) -> (a.x() != b.x()) ? a.x() - b.x() : b.y() - a.y());
        this.p = points.get(0);
        this.q = points.get(1);
    }

    public Line(Points points) {
        this(points.get(0), points.get(1));
    }

    public double length() {
        return Math.sqrt(Math.pow((p.x() - q.x()), 2.0) + Math.pow((p.y() - q.y()), 2.0));
    }

    public double gradient() {
        return (double) (q.y() - p.y()) / (q.x() - p.x());
    }

    public boolean intersectsWith(Line l) {
        return ((p.x() - q.x()) * (l.p.y() - p.y()) + (p.y() - q.y()) * (p.x() - l.p.x()))
                * ((p.x() - q.x()) * (l.q.y() - p.y()) + (p.y() - q.y()) * (p.x() - l.q.x())) < 0
                && ((l.p.x() - l.q.x()) * (p.y() - l.p.y()) + (l.p.y() - l.q.y()) * (l.p.x() - p.x()))
                * ((l.p.x() - l.q.x()) * (q.y() - l.p.y()) + (l.p.y() - l.q.y()) * (l.p.x() - q.x())) < 0;
    }

    public boolean onTheSameLineWith(Point R) {
        return Double.compare(gradient() * (R.x() - p.x()) + p.y() - R.y(), .0) == 0
                || R.x() == p.x() && p.x() == q.x();
    }

    public boolean includes(Point R) {
        return onTheSameLineWith(R) && p.x() <= R.x() && R.x() <= q.x();
    }

    public boolean isConnectedTo(Line l) {
        return l.includes(p) || l.includes(q);
    }

    public Point getCommonPointWith(Line l) {
        if (l.includes(p)) {
            return p;
        }
        if (l.includes(q)) {
            return q;
        }
        return null;
    }

    @Override
    public String toString() {
        return p.toString() + "-" + q.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        Line rhs = (Line) o;
        return Objects.equals(p, rhs.p) && Objects.equals(q, rhs.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, q);
    }
}
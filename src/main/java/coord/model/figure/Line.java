package coord.model.figure;

import java.util.Objects;

public final class Line {
    public final Point P;
    public final Point Q;

    public Line(Point P, Point Q) {
        if (P.x > Q.x) {
            Point temp = Q;
            Q = P;
            P = temp;
        }
        this.P = P;
        this.Q = Q;
    }

    public Line(Points points) {
        this(points.getPoints().get(0), points.getPoints().get(1));
    }

    public double length() {
        return Math.sqrt(Math.pow((P.x - Q.x), 2.0) + Math.pow((P.y - Q.y), 2.0));
    }

    public double gradient() {
        return (double) (Q.y - P.y) / (Q.x - P.x);
    }

    public boolean onTheSameLineWith(Point R) {
        return Double.compare(gradient() * (R.x - P.x) + P.y - R.y, .0) == 0 || R.x == P.x && P.x == Q.x;
    }

    public boolean includes(Point R) {
        return onTheSameLineWith(R) && P.x <= R.x && R.x <= Q.x;
    }

    public boolean intersectsWith(Line b) {
        return ((P.x - Q.x) * (b.P.y - P.y) + (P.y - Q.y) * (P.x - b.P.x))
                * ((P.x - Q.x) * (b.Q.y - P.y) + (P.y - Q.y) * (P.x - b.Q.x)) < 0
                && ((b.P.x - b.Q.x) * (P.y - b.P.y) + (b.P.y - b.Q.y) * (b.P.x - P.x))
                * ((b.P.x - b.Q.x) * (Q.y - b.P.y) + (b.P.y - b.Q.y) * (b.P.x - Q.x)) < 0;
    }

    public boolean isConnectedTo(Line b) {
        return b.includes(P) || b.includes(Q);
    }

    @Override
    public String toString() {
        return P.toString() + "-" + Q.toString();
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
        return Objects.equals(P, rhs.P) && Objects.equals(Q, rhs.Q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(P, Q);
    }
}
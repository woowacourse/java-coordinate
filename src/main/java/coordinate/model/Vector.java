package coordinate.model;

import java.util.Objects;

class Vector {
    private Delta xDelta;

    private Delta yDelta;

    private Vector(Delta xDelta, Delta yDelta){
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    Vector(Point firstPoint, Point secondPoint) {
        this.xDelta = new Delta((int) secondPoint.getXValue().getRateOfChange(firstPoint.getXValue()));
        this.yDelta = new Delta((int) secondPoint.getYValue().getRateOfChange(firstPoint.getYValue()));
    }

    Delta getxDelta() {
        return xDelta;
    }

    Delta getyDelta() {
        return yDelta;
    }

    double getDotProduct(Vector vector) {
        return Math.abs(this.xDelta.multiply(vector.xDelta) + this.yDelta.multiply(vector.yDelta));
    }

    double getCrossProduct(Vector vector) {
        return Math.abs(this.xDelta.multiply(vector.yDelta) + this.yDelta.multiply(vector.xDelta));
    }

    Vector sum(Vector vector) {
        return new Vector(xDelta.sum(vector.xDelta), yDelta.sum(vector.yDelta));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(xDelta, vector.xDelta) &&
                Objects.equals(yDelta, vector.yDelta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xDelta, yDelta);
    }
}

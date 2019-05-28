package coordinate.domain;

import java.util.Objects;

class Vector implements Comparable {
    private int deltaX;
    private int deltaY;

    private Vector(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    Vector(Point start, Point end) {
        deltaX = end.getX() - start.getX();
        deltaY = end.getY() - start.getY();
    }

    int dotProduct(Vector objVector) {
        return deltaX * objVector.deltaX + deltaY * objVector.deltaY;
    }

    int crossProduct(Vector objVector) {
        return deltaX * objVector.deltaY - deltaY * objVector.deltaX;
    }

    double length() {
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    Vector add(Vector objVector) {
        return new Vector(deltaX + objVector.deltaX, deltaY + objVector.deltaY);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(length() - ((Vector) o).length(),0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return deltaX == vector.deltaX &&
                deltaY == vector.deltaY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deltaX, deltaY);
    }
}

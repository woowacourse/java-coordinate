package coordinate.util;

import java.util.Objects;

public class Vector implements Comparable {
    private int deltaX;
    private int deltaY;

    public Vector(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int dotProduct(Vector objVector) {
        return objVector.multiplyToDeltaX(this.deltaX) + objVector.multiplyToDeltaY(this.deltaY);
    }

    private int multiplyToDeltaX(int scale) {
        return scale * deltaX;
    }

    private int multiplyToDeltaY(int scale) {
        return scale * deltaY;
    }

    public int crossProduct(Vector objVector) {
        return objVector.multiplyToDeltaY(this.deltaX) - objVector.multiplyToDeltaX(this.deltaY);
    }

    public double length() {
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public Vector add(Vector objVector) {
        return new Vector(objVector.addToDeltaX(deltaX), objVector.addToDeltaY(deltaY));
    }

    private int addToDeltaX(int scale) {
        return scale + deltaX;
    }

    private int addToDeltaY(int scale) {
        return scale + deltaY;
    }


    @Override
    public int compareTo(Object o) {
        return Double.compare(length() - ((Vector) o).length(), 0);
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

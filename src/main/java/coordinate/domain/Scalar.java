package coordinate.domain;

import java.util.Objects;

public class Scalar {
    private final int no;

    public Scalar(int no) {
        this.no = no;
    }

    boolean isMoreThan(int no) {
        return this.no > no;
    }

    boolean isLessThan(int no) {
        return this.no < no;
    }

    Scalar sub(Scalar scalar) {
        return new Scalar(no - scalar.getNo());
    }

    Scalar add(Scalar scalar) {
        return new Scalar((no + scalar.getNo()));
    }

    Scalar multiply(Scalar scalar) {
        return new Scalar(no * scalar.getNo());
    }

    int getNo() {
        return no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scalar)) return false;
        Scalar scalar = (Scalar) o;
        return getNo() == scalar.getNo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNo());
    }
}

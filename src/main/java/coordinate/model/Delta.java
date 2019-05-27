package coordinate.model;

import java.util.Objects;

class Delta {
    private final int deltaValue;

    Delta(int delta) {
        this.deltaValue = delta;
    }

    int getDeltaValue() {
        return deltaValue;
    }

    Delta sum(Delta delta) {
        return new Delta(this.deltaValue + delta.deltaValue);
    }

    double multiply(Delta delta) {
        return (double) this.deltaValue * delta.deltaValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delta delta = (Delta) o;
        return deltaValue == delta.deltaValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deltaValue);
    }
}
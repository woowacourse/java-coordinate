package com.woowa.coordinate.domain;

import java.util.Objects;

public class Delta {
    private final int delta;

    public Delta(int delta) {
        this.delta = delta;
    }

    public int sum(Delta delta) {
        return this.delta + delta.delta;
    }

    public int multiply(Delta delta) {
        return this.delta * delta.delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delta that = (Delta) o;
        return delta == that.delta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(delta);
    }
}

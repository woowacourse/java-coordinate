package location.domain;

import java.util.Objects;

public class YPoint {
    private final int value;

    public YPoint(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final YPoint yPoint = (YPoint) o;
        return value == yPoint.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

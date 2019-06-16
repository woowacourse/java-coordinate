package location.domain;

import java.util.Objects;

public class XPoint {
    private final int value;

    public XPoint(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final XPoint xPoint = (XPoint) o;
        return value == xPoint.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

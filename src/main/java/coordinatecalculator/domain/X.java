package coordinatecalculator.domain;

import java.util.Objects;

public class X extends AxisValidator {
    private final int x;

    public X(final String x) {
        checkNumeric(x);
        checkBoundary(Integer.parseInt(x));
        this.x = Integer.parseInt(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        X x1 = (X) o;
        return Objects.equals(x, x1.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}

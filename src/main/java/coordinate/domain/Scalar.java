package coordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Scalar {
    private static final Map<Integer, Scalar> scalarHashMap = new HashMap<>();
    private final int no;

    private Scalar(int no) {
        this.no = no;
    }

    static Scalar of(int no) {
        if (!scalarHashMap.containsKey(no)) {
            scalarHashMap.put(no, new Scalar(no));
        }
        return scalarHashMap.get(no);
    }

    boolean isMoreThan(int no) {
        return this.no > no;
    }

    boolean isLessThan(int no) {
        return this.no < no;
    }

    int sub(Scalar scalar) {
        return no - scalar.no;
    }

    int add(Scalar scalar) {
        return no + scalar.no;
    }

    int multiply(Scalar scalar) {
        return no * scalar.no;
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
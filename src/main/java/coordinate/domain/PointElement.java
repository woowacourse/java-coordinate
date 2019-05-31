package coordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PointElement {
    public static final int MIN_POINT = 0;
    public static final int MAX_POINT = 24;
    private final static Map<Integer, PointElement> MAP;

    private final int point;

    static {
        MAP = new HashMap<>();
        for (int i = MIN_POINT; i <= MAX_POINT; i++) {
            MAP.put(i, new PointElement(i));
        }
    }

    private PointElement(final int point) {
        this.point = point;
    }

    public static PointElement of(final int point) {
        Optional<PointElement> optPointElement = Optional.ofNullable(MAP.get(point));
        return optPointElement.orElseThrow(() -> new IllegalArgumentException("범위내의 좌표를 입력하세요 (0 ~ 24)"));
    }

    int minus(final PointElement other) {
        return (this.point - other.point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointElement)) return false;
        PointElement that = (PointElement) o;
        return (point == that.point);
    }

    @Override
    public String toString() {
        return String.valueOf(this.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}

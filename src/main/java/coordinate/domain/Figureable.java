package coordinate.domain;

import java.util.List;

public interface Figureable {
    double area(List<Double> lineDistance);
    void validateNumOf(Lines lines, int size);
}

package coordinate.domain;

@FunctionalInterface
public interface PointGenerator {
    AbstractPoint of(CoordinateNumber x, CoordinateNumber y);
}

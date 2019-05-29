package coordinate.domain;

@FunctionalInterface
public interface PointGenerator {
    Point of(int x, int y);
}

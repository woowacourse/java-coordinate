package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Coordinate {
    private final int coordinate;

    private Coordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public int getMinus(Coordinate otherCoordinate) {
        return this.coordinate - otherCoordinate.coordinate;
    }

    public int getCoordinate() {
        return coordinate;
    }

    private static class CoordinateCache {
        static final int low = 0;
        static final int high = 24;
        static final List<Coordinate> cache = new ArrayList<>();

        static {
            IntStream.range(low, high)
                    .boxed()
                    .forEach(x -> cache.add(new Coordinate(x)));
        }

        private CoordinateCache() {
        }
    }

    public static Coordinate valueOf(int i) {
        if (i >= CoordinateCache.low && i <= CoordinateCache.high) {
            return CoordinateCache.cache.get(i);
        }
        throw new IllegalArgumentException("올바른 좌표값을 입력해주세요");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return coordinate == that.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}

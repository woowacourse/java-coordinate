package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Coordinate {
    private final int cor;

    private Coordinate(int cor) {
        this.cor = cor;
    }

    public int getMinus(Coordinate x) {
        return cor - x.cor;
    }

    public int getCoordinate() {
        return cor;
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
}

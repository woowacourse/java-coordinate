package coordinate.domain;

import java.util.Objects;

public class CoordinateNumber {
    // [NUM_BEGIN, NUM_END)
    private static final int NUM_CACHE_BEGIN = 0;
    private static final int NUM_CACHE_END = 25;

    private final int number;

    public CoordinateNumber(int number) {
        this.number = number;
    }

    public static CoordinateNumber valueOf(int i) {
        if (CoordinateNumberCache.isCached(i)) {
            return CoordinateNumberCache.getFromCache(i);
        }
        return new CoordinateNumber(i);
    }

    public int toInt() {
        return number;
    }

    public int subtract(CoordinateNumber a) {
        return number - a.toInt();
    }

    private static class CoordinateNumberCache {
        static final int begin = NUM_CACHE_BEGIN;
        static final int end = NUM_CACHE_END;
        static final CoordinateNumber[] cache;

        static {
            cache = new CoordinateNumber[end - begin];
            for (int i = begin; i < end; i++) {
                cache[i - begin] = new CoordinateNumber(i);
            }
        }

        static boolean isCached(int i) {
            if (begin <= i && i < end) {
                return true;
            }
            return false;
        }

        static CoordinateNumber getFromCache(int i) {
            return cache[i - begin];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateNumber that = (CoordinateNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

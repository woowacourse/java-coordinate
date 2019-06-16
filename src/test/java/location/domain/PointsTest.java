package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {

    @Test
    void 빈_포인트() {
        assertThrows(IllegalArgumentException.class, () -> new Points(Arrays.asList()));
    }

    @Test
    void NULL_포인트() {
        assertThrows(IllegalArgumentException.class, () -> new Points(null));
    }

}

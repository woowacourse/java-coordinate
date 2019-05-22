package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {

    @Test
    void 동일한_점_일때() {
        assertThrows(IllegalArgumentException.class, () -> new Points(Arrays.asList(new Point(10, 10), new Point(10, 10))));
    }
}

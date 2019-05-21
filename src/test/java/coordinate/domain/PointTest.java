package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void Point_생성() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Point(25, 0);
        });
    }
}

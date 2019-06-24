package coordinate.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleComparatorTest {
    @Test
    void doubleEqualTest() {
        assertThat(DoubleComparator.isEqual(0.5, 0.50000000004));
    }
}

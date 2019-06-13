package coordinate.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleCompareTest {
    @Test
    void Double_소수점_한_자리() {
        assertThat(DoubleCompare.deltaCompare(1.1, 1.109, 0.1)).isTrue();
    }

    @Test
    void Double_소수점_두_자리() {
        assertThat(DoubleCompare.deltaCompare(1.11, 1.119, 0.01)).isTrue();
    }

    @Test
    void Double_소수점_세_자리() {
        assertThat(DoubleCompare.deltaCompare(1.112, 1.1129, 0.01)).isTrue();
    }
}

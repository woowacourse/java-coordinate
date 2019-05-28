package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScalarTest {
    @Test
    void 스칼라_범위_테스트() {
        assertThat(Scalar.of(1).isMoreThan(0)).isTrue();
        assertThat(Scalar.of(24).isLessThan(25)).isTrue();
    }

    @Test
    void 스칼라_계산_테스트() {
        assertThat(Scalar.of(5).sub(Scalar.of(3))).isEqualTo(Scalar.of(2));
        assertThat(Scalar.of(5).add(Scalar.of(3))).isEqualTo(Scalar.of(8));
        assertThat(Scalar.of(5).multiply(Scalar.of(3))).isEqualTo(Scalar.of(15));
    }
}
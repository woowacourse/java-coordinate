package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScalarTest {
    @Test
    void 스칼라_범위_테스트() {
        assertThat(new Scalar(1).isMoreThan(0)).isTrue();
        assertThat(new Scalar(24).isLessThan(25)).isTrue();
    }

    @Test
    void 스칼라_계산_테스트() {
        assertThat(new Scalar(5).sub(new Scalar(3))).isEqualTo(new Scalar(2));
        assertThat(new Scalar(5).add(new Scalar(3))).isEqualTo(new Scalar(8));
        assertThat(new Scalar(5).multiply(new Scalar(3))).isEqualTo(new Scalar(15));
    }
}
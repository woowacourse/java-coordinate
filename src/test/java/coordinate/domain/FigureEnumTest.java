package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FigureEnumTest {
    @Test
    void 점이_두개면_라인() {
        assertThat(FigureEnum.valueOf(2)).isEqualTo(FigureEnum.LINE);
    }

    @Test
    void 점이_세개면_삼각형() {
        assertThat(FigureEnum.valueOf(3)).isEqualTo(FigureEnum.TRIANGLE);
    }

    @Test
    void 점이_네개면_사각형() {
        assertThat(FigureEnum.valueOf(4)).isEqualTo(FigureEnum.RECTANGLE);
    }
}

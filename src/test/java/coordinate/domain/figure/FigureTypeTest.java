package coordinate.domain.figure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureTypeTest {
    @Test
    void 라인() {
        assertThat(FigureType.valueOf(2)).isEqualTo(FigureType.LINE);
    }

    @Test
    void 삼각형() {
        assertThat(FigureType.valueOf(3)).isEqualTo(FigureType.TRIANGLE);
    }

    @Test
    void 사각형() {
        assertThat(FigureType.valueOf(4)).isEqualTo(FigureType.RECTANGLE);
    }

    @Test
    void 유효하지_않은_도형() {
        assertThrows(InvalidFigureTypeException.class, () -> {
            FigureType.valueOf(5);
        });

        assertThrows(InvalidFigureTypeException.class, () -> {
            FigureType.valueOf(1);
        });
    }
}

package coordinate.domain.figure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"2:LINE", "3:TRIANGLE", "4:RECTANGLE"}, delimiter = ':')
    void 도형_형성(int size, FigureType figureType) {
        assertThat(FigureType.valueOf((size))).isEqualTo(figureType);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void 유효하지_않은_도형(int size) {
        assertThrows(InvalidFigureException.class, () -> {
            FigureType.valueOf(size);
        });
    }
}
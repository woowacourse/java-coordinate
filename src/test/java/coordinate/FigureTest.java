package coordinate;

import coordinate.domain.FigureFactory;
import coordinate.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FigureTest {
    FigureFactory figureFactory;
    List<Point> points;

    @BeforeEach
    public void setUp() {
        figureFactory = FigureFactory.getInstance();
    }

    @Test
    public void Factory클래스가_삼각형을_생성하는지_검증() {
        points = Arrays.asList(
                Point.of(0, 0),
                Point.of(0, 3),
                Point.of(4, 0));
        Figure triangle = figureFactory.create(points);
        assertThat(triangle.getArea()).isEqualTo(6.0, offset(0.00099));
    }

    @Test
    public void Factory클래스가_사각형을_생성하는지_검증() {
        points = Arrays.asList(
                Point.of(22, 24),
                Point.of(24, 24),
                Point.of(22, 22),
                Point.of(24, 22));

        Figure square = figureFactory.create(points);
        assertThat(square.getArea()).isEqualTo(4.0, offset(0.0099));
    }

    @Test
    public void points의_크기가_5일때_예외발생하는지() {
        points = Arrays.asList(
                Point.of(22, 24),
                Point.of(24, 24),
                Point.of(22, 22),
                Point.of(24, 22),
                Point.of(23, 21));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            figureFactory.create(points);
        });
    }
}
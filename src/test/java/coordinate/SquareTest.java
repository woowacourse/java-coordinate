package coordinate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SquareTest {
    List<Point> points;

    @Test
    public void 넓이가_1인_직사각형을_제대로_생성하는지() {
        points = Arrays.asList(
                Point.of(1, 1),
                Point.of(2, 2),
                Point.of(1, 2),
                Point.of(2, 1));
        Square square = new Square(points);
        assertThat(square.getArea()).isEqualTo(1.0, offset(0.0099));
    }

    @Test
    public void 넓이가_4인_직사각형을_제대로_생성하는지() {
        points = Arrays.asList(
                Point.of(22, 24),
                Point.of(24, 24),
                Point.of(22, 22),
                Point.of(24, 22));

        Square square = new Square(points);
        assertThat(square.getArea()).isEqualTo(4.0, offset(0.0099));

    }

    @Test
    public void 넓이가_8인_직사각형_4X2_을_제대로_생성하는지() {
        points = Arrays.asList(
                Point.of(0, 0),
                Point.of(0, 2),
                Point.of(4, 2),
                Point.of(4, 0));

        Square square = new Square(points);
        assertThat(square.getArea()).isEqualTo(8.0, offset(0.0099));
    }

    @Test
    public void 직사각형이_아닐때_예외를_발생시키는지_검증() {
        points = Arrays.asList(
                Point.of(0, 0),
                Point.of(0, 2),
                Point.of(4, 2),
                Point.of(4, 1));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Square square = new Square(points);
            assertThat(square.getArea()).isEqualTo(8.0, offset(0.0099));
        });
    }

    @AfterEach
    public void after() {
        points = null;
    }
}
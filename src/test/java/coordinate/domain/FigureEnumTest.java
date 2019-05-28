package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static coordinate.domain.FigureEnum.figureOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FigureEnumTest {

    @Test
    public void Point_2개_입력됐을_때_Line을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2))));

        assertThat(figureOf(vertices) instanceof Line).isTrue();
    }

    @Test
    public void Point_3개_입력됐을_때_Triangle을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(1, 2))));

        assertThat(figureOf(vertices) instanceof Triangle).isTrue();
    }

    @Test
    public void Point_4개_입력됐을_때_Rectangle을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(1, 2), new Point(2, 1))));

        assertThat(figureOf(vertices) instanceof Rectangle).isTrue();
    }

    @Test
    public void Point_5개_입력됐을_때_예외를_던지는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(4, 5), new Point(6, 7),
        new Point(23, 21))));

        assertThatThrownBy(() -> {
            figureOf(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureFactoryTest {
    @Test
    public void Point_2개_입력됐을_때_Line을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2))));

        assertThat(new FigureFactory().generate(vertices) instanceof Line).isTrue();
    }

    @Test
    public void Point_3개_입력됐을_때_Triangle을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2))));

        assertThat(new FigureFactory().generate(vertices) instanceof Triangle).isTrue();
    }

    @Test
    public void Point_4개_입력됐을_때_Rectangle을_만드는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2))));

        assertThat(new FigureFactory().generate(vertices) instanceof Rectangle).isTrue();
    }

    @Test
    public void Point_5개_입력됐을_때_예외를_던지는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2))));

        assertThatThrownBy(() -> {
            new FigureFactory().generate(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class TriangleTest {

    AbstractFigure triangle;
    Points points;
    FigureType figureType;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(new Point(0, 0));
        points.add(new Point(10, 0));
        points.add(new Point(5, 10));
        figureType = FigureType.valueOf(points);
        triangle = new FigureFactory().create(figureType);

    }

    @Test
    void create_생성_확인() {
        assertThat(triangle).isEqualTo(new FigureFactory().create(figureType));
    }

    @Test
    void create_일직선_예외_확인() {
        Points exPoints = new Points();
        exPoints.add(new Point(0,0));
        exPoints.add(new Point(1,1));
        exPoints.add(new Point(2,2));
        assertThrows(Exception.class, () -> {
            new FigureFactory().create(FigureType.valueOf(exPoints));
        });
    }

    @Test
    void area_삼각형_넓이_확인() {
        assertThat(triangle.area()).isEqualTo(50.000, offset(0.00099));
    }
}

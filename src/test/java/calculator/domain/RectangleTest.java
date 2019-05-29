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
public class RectangleTest {

    AbstractFigure rectangle;
    Points points;
    FigureType figureType;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(new Point(0, 0));
        points.add(new Point(10, 0));
        points.add(new Point(0, 10));
        points.add(new Point(10, 10));
        figureType = FigureType.valueOf(points);
        rectangle = new FigureFactory().create(figureType);
    }

    @Test
    void create_생성_확인() {
        assertThat(rectangle).isEqualTo(new FigureFactory().create(figureType));
    }

    @Test
    void create_직사각형_예외_확인() {
        Points pointsException = new Points();
        pointsException.add(new Point(10,20));
        pointsException.add(new Point(10,10));
        pointsException.add(new Point(0,10));
        pointsException.add(new Point(1,10));

        assertThrows(Exception.class, () -> {
            new FigureFactory().create(FigureType.valueOf(pointsException));
        });
    }

    @Test
    void area_사각형_넓이_확인() {
        assertThat(rectangle.area()).isEqualTo(100.000, offset(0.00099));
    }
}

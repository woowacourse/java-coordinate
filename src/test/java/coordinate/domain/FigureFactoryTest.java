package coordinate.domain;

import coordinate.domain.FigureFactory;
import coordinate.domain.Point;
import coordinate.domain.PointFactory;
import coordinate.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureFactoryTest {

    @Test
    void 길이구하기() {
        Points points = PointFactory.generatePoints(Arrays.asList("1,1", "1,2"));
        assertEquals(FigureFactory.generateFigure(points).getArea(), 1);
    }
}

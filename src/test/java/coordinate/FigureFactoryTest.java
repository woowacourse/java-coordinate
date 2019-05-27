package coordinate;

import coordinate.domain.FigureFactory;
import coordinate.domain.Point;
import coordinate.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureFactoryTest {

    @Test
    void 길이구하기() {
        Points points = new Points(Arrays.asList(new Point("1","1"),new Point("1","2") ));
        assertEquals(FigureFactory.generateFigure(points).getArea(),1);
    }
}

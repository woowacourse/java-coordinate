package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureFactoryTest {

    @Test
    void 길이구하기() {
        PointList points = new PointList(Arrays.asList(new Point("1","1"),new Point("1","2") ));
        assertEquals(FigureFactory.generateFigure(points).findArea(),1);
    }
}

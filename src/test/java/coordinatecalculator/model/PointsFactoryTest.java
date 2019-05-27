package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsFactoryTest {

    @Test
    void 중복된_좌표_유효성_테스트() {
        String testString = "(1,1)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> PointsFactory.generatePoints(testString));
    }

    @Test
    void 한점만_있을_때_테스트() {
        String testString = "(1,1)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> PointsFactory.generatePoints(testString));
    }

    @Test
    void 숫자_범위테스트() {
        String testString = "(25,25)-(1,1)";
        assertThrows(IllegalArgumentException.class, ()-> PointsFactory.generatePoints(testString));
    }
}

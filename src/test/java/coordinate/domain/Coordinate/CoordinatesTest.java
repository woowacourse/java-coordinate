package coordinate.domain.Coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesTest {
    @Test
    void 좌표두개1() {
        Coordinates coordinate = Coordinates.create(5, 3);
        assertEquals(coordinate.getDistanceWith(Coordinates.create(9, 7))
                , 5.0, 0.1);
    }

    @Test
    void 좌표두개2() {
        Coordinates coordinate = Coordinates.create(0, 0);
        assertEquals(coordinate.getDistanceWith(Coordinates.create(0, 0))
                , 0.0, 0.1);
    }
}

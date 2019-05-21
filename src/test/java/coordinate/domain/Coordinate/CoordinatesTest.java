package coordinate.domain.Coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesTest {
    @Test
    void 좌표두개1() {
        Coordinates coor1 = new Coordinates(new XCoordinate(6), new YCoordinate(3));
        Coordinates coor2 = new Coordinates(new XCoordinate(9), new YCoordinate(7));
        assertEquals(coor1.getDistanceWith(coor2), 5.0, 0.1);
    }

    @Test
    void 좌표두개2() {
        Coordinates coor1 = new Coordinates(new XCoordinate(0),new YCoordinate(0));
        Coordinates coor2 = new Coordinates(new XCoordinate(0), new YCoordinate(0));
        assertEquals(coor1.getDistanceWith(coor2), 0.0, 0.1);
    }
}

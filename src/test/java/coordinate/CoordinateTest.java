package coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {
    @Test
    void 좌표두개1() {
        Coordinate coor1 = new Coordinate(6, 3);
        Coordinate coor2 = new Coordinate(9, 7);
        //Result.getDistance(coor1, coor2);
        assertEquals(coor1.getDistanceWith(coor2), 5.0, 0.1);
    }

    @Test
    void 좌표두개2() {
        Coordinate coor1 = new Coordinate(0,0);
        Coordinate coor2 = new Coordinate(0, 0);
        //Result.getDistance(coor1, coor2);
        assertEquals(coor1.getDistanceWith(coor2), 0.0, 0.1);
    }
}

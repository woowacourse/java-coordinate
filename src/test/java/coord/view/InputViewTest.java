package coord.view;

import coord.model.Point;
import coord.model.Points;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {
    @Test
    void parseTest() {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream("(1,2)-(3,4)-(5,6)".getBytes());
            System.setIn(inputStream);

            assertEquals(Arrays.asList(new Point(5, 6), new Point(3, 4), new Point(1, 2)),
                    InputView.inputCoordinates().getPoints());
        } finally {
            System.setIn(System.in);
        }
    }
}
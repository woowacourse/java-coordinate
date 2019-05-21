package rentCar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {
    @Test
    public void 자동차정상생성() throws Exception {
        assertDoesNotThrow(() -> {
            new K5(100);
        });
    }

    @Test
    public void 자동차생성오류() throws Exception {
        assertThrows(Exception.class, () -> {
            new K5(-100);
        });
    }
}

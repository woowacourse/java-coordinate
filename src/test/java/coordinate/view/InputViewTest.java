package coordinate.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

        @Test
        void 좌표_입력_형식_예외() {
                assertThrows(IllegalArgumentException.class, () -> {
                        ByteArrayInputStream input = new ByteArrayInputStream("(0,0)=".getBytes());
                        System.setIn(input);
                        InputView.inputPoint();
                });
        }

        @Test
        void 좌표_수_예외() {
                assertThrows(IllegalArgumentException.class, () -> {
                        ByteArrayInputStream input = new ByteArrayInputStream("(1,1)-(2,2)-(3,3)-(4,4)-(5,5)".getBytes());
                        System.setIn(input);
                        InputView.inputPoint();
                });
        }

        @AfterEach
        void flushSTDIn() {
                System.setIn(System.in);
        }
}

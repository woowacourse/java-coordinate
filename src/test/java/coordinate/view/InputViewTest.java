package coordinate.view;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @Test
    void 괄호가_없는_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkValidFormat("(1,2)-2,3");
        });
    }
}

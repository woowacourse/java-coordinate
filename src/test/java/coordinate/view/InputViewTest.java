package coordinate.view;

import coordinate.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
	@Test
	public void 올바른_입력에_대하여_제대로된_Point리스트를_반환하는지() {
		assertThat(InputView.inputCoordinate("(1,2)-(3,4)")).isEqualTo(Arrays.asList(
				Point.of(1, 2),
				Point.of(3, 4)
		));
	}
}
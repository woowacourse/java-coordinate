package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardSingleLineTest {
    @Test
    void 보드_한_라인_초기화하는_테스트() {
        BoardSingleLine boardSingleLine = new BoardSingleLine();
        assertThat(boardSingleLine).isEqualTo(new BoardSingleLine());
    }
}

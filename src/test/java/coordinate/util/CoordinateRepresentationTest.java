package coordinate.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateRepresentationTest {
    @Test
    void 정상좌표_두개_입력() {
        assertDoesNotThrow(() -> {
            CoordinateRepresentation.convertCoordinatePair("(1,2)-(2,2)");
        });
    }

    @Test
    void 중복좌표_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(1,2)-(1,2)");
        });
    }

    @Test
    void 좌표_두개_사이_별_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(1,2)*(2,2)");
        });
    }

    @Test
    void 정상좌표_한개_입력() {
        assertDoesNotThrow(() -> {
            CoordinateRepresentation.convertCoordinatePair("(1,2)");
        });
    }

    @Test
    void 좌표_하나_안에_숫자_아닌_문자() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(a,3)");
        });
    }

    @Test
    void 좌표_하나_안에_쉼표_대신_다른_문자() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(1/2)");
        });
    }

    @Test
    void 좌표_하나_안에_숫자_하나() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(2)");
        });
    }

    @Test
    void 괄호가_열린_좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(1,2");
        });
    }

    @Test
    void 음수가_포함된_좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateRepresentation.convertCoordinatePair("(-1,3)");
        });
    }
}





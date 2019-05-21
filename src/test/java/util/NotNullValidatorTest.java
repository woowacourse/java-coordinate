package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotNullValidatorTest {
    @Test
    void nullTest() {
        assertThrows(IllegalArgumentException.class, () -> NotNullValidator.validateNotNull(null));
    }
}

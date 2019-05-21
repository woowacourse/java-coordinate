package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotNullValidatorTest {
    @Test
    void nullTest() {
        assertThrows(IllegalArgumentException.class, () -> NotNullValidator.validateNotNull(null));
    }

    @Test
    void listNullTest() {
        List<Integer> testList = new ArrayList<>();
        testList.add(null);
        assertThrows(IllegalArgumentException.class, () -> NotNullValidator.validateNotNull(testList));
    }
}

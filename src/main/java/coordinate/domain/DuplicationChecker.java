package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationChecker {
    public static <T> boolean hasDuplication(List<T> values) {
        Set<T> s = new HashSet<>(values);
        return s.size() != values.size();
    }
}

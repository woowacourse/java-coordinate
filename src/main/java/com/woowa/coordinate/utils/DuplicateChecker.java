package com.woowa.coordinate.utils;

import com.woowa.coordinate.domain.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateChecker {
    private static final String DUPLICATE_ERROR = "중복된 좌표가 입력되었습니다.";

    public static List<Point> check(List<Point> input) {
        Set<Point> duplicatedChecker = new HashSet<>(input);
        if (duplicatedChecker.size() != input.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
        return new ArrayList<>(input);
    }
}

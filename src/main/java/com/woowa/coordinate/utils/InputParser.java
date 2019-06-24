package com.woowa.coordinate.utils;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String FORMAT_ERROR = "입력 형식이 올바르지 않습니다.";
    private static final String BRACE_OPEN = "(";
    private static final String BRACE_CLOSE = ")";
    private static final String EMPTY = "";

    public static Points point(String input) {
        validStyle(input);
        return getPoints(input);
    }

    private static void validStyle(String input) {
        if (!input.matches("(\\([0-9]+,[0-9]+\\))+(\\-\\([0-9]+,[0-9]+\\)+)*")) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }

    private static Points getPoints(String input) {
        String[] splitInput = input.split("-");
        List<Point> points = new ArrayList<>();
        for (String point : splitInput) {
            points.add(Point.of(removeBraces(point)));
        }
        return new Points(points);
    }

    private static String removeBraces(String point) {
        return point.replace(BRACE_OPEN, EMPTY)
                .replace(BRACE_CLOSE, EMPTY);
    }
}

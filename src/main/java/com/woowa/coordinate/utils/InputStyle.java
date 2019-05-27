package com.woowa.coordinate.utils;

public class InputStyle {
    public static String coordinateChecker(String input) {
        if(!input.matches("(\\([0-9]+,[0-9]+\\))+(\\-\\([0-9]+,[0-9]+\\)+)*")) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
        return input;
    }
}

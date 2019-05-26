package com.woowacourse.javacoordinate.view;

import com.woowacourse.javacoordinate.domain.*;

import java.util.List;

public class OutputView {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;
    private static final int LENGTH_CAL_CODE = 1;
    private static final int AREA_CAL_CODE = 2;

    public static void printCoordinateSystem(CoordinateSystem coordinateSystem) {
        List<CoordinateLine> lines = coordinateSystem.getCoordinateLines();

        for (int i = MAX_COORDINATE; i >= MIN_COORDINATE; i--) {
            printCoordinateLine(lines, i);
        }

        // 마지막 줄
        printXAxis();
        printXAxisNumber();
        System.out.println();
    }

    private static void printCoordinateLine(List<CoordinateLine> lines, int i) {
        if (checkYAxisMarkingLine(lines, i)) {
            return;
        }

        System.out.println("  " + "|" + lines.get(i).printLine());
    }

    private static void printXAxis() {
        System.out.print("  +");
        printDash();
        System.out.println();
    }

    private static boolean checkYAxisMarkingLine(List<CoordinateLine> lines, int i) {
        if (i % 2 == 0) {
            System.out.println(String.format("%2d|", i) + lines.get(i).printLine());

            return true;
        }
        return false;
    }

    private static void printDash() {
        for (int j = 0; j < MAX_COORDINATE; j++) {
            System.out.print("--");
        }
    }

    private static void printXAxisNumber() {
        System.out.print("   0");
        for (int i = 1; i <= MAX_COORDINATE; i++) {
            checkEvenXAxis(i);
        }
    }

    private static void checkEvenXAxis(int i) {
        if (i % 2 == 0) {
            System.out.print(String.format("%4d", i));
        }
    }

    public static void printResult(Figure figure, int calculateCode) {
        if (calculateCode == LENGTH_CAL_CODE) {
            System.out.println(figure.getName() + "길이는 "+ figure.calculateLength());
            return;
        }
        if (calculateCode == AREA_CAL_CODE) {
            System.out.println(figure.getName() + "넓이는 "+ figure.calculateArea());
        }
    }
}

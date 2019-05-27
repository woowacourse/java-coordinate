package com.woowa.coordinate.view;

import com.woowa.coordinate.utils.InputStyle;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String request() {
        try {
            System.out.println("좌표를 입력하세요");
            return InputStyle.coordinateChecker(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return request();
        }
    }
}

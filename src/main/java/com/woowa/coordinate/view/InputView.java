package com.woowa.coordinate.view;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.utils.InputParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Point> getRequest() {
        try {
            OutputView.request();
            return InputParser.point(request());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRequest();
        }
    }

    private static String request() {
        return scanner.nextLine();
    }
}

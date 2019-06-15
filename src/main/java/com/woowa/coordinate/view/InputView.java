package com.woowa.coordinate.view;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.utils.InputParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Point> request() {
        try {
            System.out.println("좌표를 입력하세요");
            return InputParser.point(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return request();
        }
    }
}

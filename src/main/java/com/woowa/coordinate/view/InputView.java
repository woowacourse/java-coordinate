package com.woowa.coordinate.view;

import com.woowa.coordinate.domain.GenerateFigure;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.utils.InputParser;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Figure getFigure() {
        try {
            Points points = InputView.getRequest();
            return GenerateFigure.getFigure(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFigure();
        }
    }

    public static Points getRequest() {
        OutputView.request();
        return InputParser.point(request());
    }

    private static String request() {
        return scanner.nextLine();
    }
}

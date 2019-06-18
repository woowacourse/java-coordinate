package com.woowa.coordinate.view;

import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.domain.figure.Line;
import com.woowa.coordinate.domain.figure.Rectangle;
import com.woowa.coordinate.domain.figure.Triangle;

public class OutputView {
    private static final String REQUEST_MESSAGE = "좌표를 입력하세요.";
    private static final String LINE_MESSAGE = "두 점 사이의 거리는 ";
    private static final String TRIANGLE_MESSAGE = "삼각형의 넓이는 ";
    private static final String RECTANGLE_MESSAGE = "사각형의 넓이는 ";

    public static void request() {
        System.out.println(REQUEST_MESSAGE);
    }

    public static void area(Figure figure) {
        if (figure instanceof Line) {
            System.out.println(LINE_MESSAGE + figure.area());
        }
        if (figure instanceof Triangle) {
            System.out.println(TRIANGLE_MESSAGE + figure.area());
        }
        if (figure instanceof Rectangle) {
            System.out.println(RECTANGLE_MESSAGE + figure.area());
        }
    }
}

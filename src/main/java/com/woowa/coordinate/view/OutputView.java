package com.woowa.coordinate.view;

import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.domain.figure.Line;
import com.woowa.coordinate.domain.figure.Triangle;

public class OutputView {
    public static void request() {
        System.out.println("좌표를 입력하세요.");
    }

    public static void area(Figure figure) {
        if (figure instanceof Line) {
            System.out.println("두 점 사이의 거리는 " + figure.area());
        }
        if (figure instanceof Triangle) {
            System.out.println("삼각형의 넓이는 " + figure.area());
        }
        if (figure instanceof Line) {
            System.out.println("사각형의 넓이는 " + figure.area());
        }
    }
}

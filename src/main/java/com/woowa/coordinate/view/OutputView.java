package com.woowa.coordinate.view;

public class OutputView {
    public static void request() {
        System.out.println("좌표를 입력하세요.");
    }

    public static void lineDistance(double distance) {
        System.out.print("두 점 사이의 거리는  " + distance);
    }

    public static void squareArea(double area) {
        System.out.print("사각형 넓이는  " + area);
    }
}

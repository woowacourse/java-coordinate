package com.woowa.rentcar.view;

import com.woowa.rentcar.domain.Distance;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static void title() {
        System.out.println("어서오세요. 우아한 렌트카 입니다.");
        System.out.println("렌트 가능 차종은 다음과 같습니다.");
        System.out.println("1. Sonata");
        System.out.println("2. Avante");
        System.out.println("3. K5");
    }

    public static String car() {
        System.out.print("렌트할 차종을 입력해주세요.\n(추가할 차가 없으면 end 를 입력) : ");
        return scanner.next();
    }

    public static Distance distance() {
        System.out.print("예상 주행 거리를 입력해주세요 : ");
        return new Distance(scanner.next());
    }
}
